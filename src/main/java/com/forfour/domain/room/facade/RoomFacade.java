package com.forfour.domain.room.facade;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.service.MemberGetService;
import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.service.ParticipantGetService;
import com.forfour.domain.participant.service.ParticipantSaveService;
import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.service.PathGetService;
import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.dto.response.RoomEndDto;
import com.forfour.domain.room.dto.response.RoomWithParticipantsDto;
import com.forfour.domain.room.dto.response.SliceRoomDto;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.event.RoomEndEvent;
import com.forfour.domain.room.event.RoomStartEvent;
import com.forfour.domain.room.exception.RoomException;
import com.forfour.domain.room.exception.RoomExceptionInformation;
import com.forfour.domain.room.service.RoomGetService;
import com.forfour.domain.room.service.RoomSaveService;
import com.forfour.domain.room.strategy.RecruitStatusStrategy;
import com.forfour.global.auth.context.MemberContext;
import com.forfour.global.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomSaveService roomSaveService;
    private final RoomGetService roomGetService;
    private final ParticipantGetService participantGetService;
    private final ParticipantSaveService participantSaveService;
    private final PathGetService pathGetService;
    private final MemberGetService memberGetService;
    private final List<RecruitStatusStrategy> strategies;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public RoomDetailDto createRoom(RoomSaveDto dto) {
        pathGetService.validatePath(dto.pathId());
        Path path = pathGetService.getPath(dto.pathId());

        Member leader = memberGetService.getMember(MemberContext.getMemberId());
        Room savedRoom = roomSaveService.save(dto, leader, path);
        enterRoom(savedRoom, leader);

        return RoomDetailDto.of(savedRoom, leader);
    }

    @Transactional
    public void participateRoom(Long roomId) {
        Room room = roomGetService.getRoomUsingLock(roomId);
        room.checkParticipate();

        Member participant = memberGetService.getMember(MemberContext.getMemberId());
        enterRoom(room, participant);
        room.increaseMemberCount();
    }

    public RoomWithParticipantsDto readRoom(Long roomId) {
        List<Participant> participants = participantGetService.getParticipants(roomId);
        Room room = roomGetService.getRoom(roomId);
        return RoomWithParticipantsDto.of(room, participants);
    }

    public SliceRoomDto readRoomScrollList(int pageSize, int pageNum, String roomStatus) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("createdAt").descending());

        if (roomStatus == null || roomStatus.isBlank()) {
            Slice<Room> slice = roomGetService.getActiveRooms(pageable);
            return SliceRoomDto.from(slice);
        }

        Slice<Room> slice = roomGetService.getActiveRoomsWithStatus(RoomStatus.valueOf(roomStatus), pageable);
        return SliceRoomDto.from(slice);
    }

    public SliceRoomDto readMyRoom(int pageSize, int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        Long memberId = MemberContext.getMemberId();
        Slice<Room> myParticipatingRoom = participantGetService.findMyParticipatingRoom(memberId, pageable)
                .map(Participant::getRoom);

        return SliceRoomDto.from(myParticipatingRoom);
    }

    @Transactional
    public void updateRecruitStatus(Long roomId, String roomStatus) {
        Room room = roomGetService.getRoomUsingLock(roomId);
        room.validateRoomLeader(MemberContext.getMemberId());

        RecruitStatusStrategy statusStrategy = findRecruitStrategy(RoomStatus.valueOf(roomStatus));
        statusStrategy.apply(room);
    }

    // TODO Spring Event 관심사 분리
    @Transactional
    public void startWalking(Long roomId, String marketId) {
        Room room = roomGetService.getRoomUsingLock(roomId);
        Path path = pathGetService.getPath(room.getPathId());
        room.validateRoomLeader(MemberContext.getMemberId());
        path.validateStartMarket(marketId);

        eventPublisher.publishEvent(RoomStartEvent.of(roomId, RoomStatus.PROGRESS));
        startRoom(room);
    }

    @Transactional
    public RoomEndDto endWalking(Long roomId, String marketId) {
        Room room = roomGetService.getRoomUsingLock(roomId);
        Path path = pathGetService.getPath(room.getPathId());
        room.validateRoomLeader(MemberContext.getMemberId());
        path.validateEndMarket(marketId);
        endRoom(room);

        eventPublisher.publishEvent(RoomEndEvent.of(room, path));
        return RoomEndDto.of(room, path);
    }

    /*
    * refactor
    * */

    private void updateParticipantStatus(Long roomId, RoomStatus status) {
        participantGetService.getParticipants(roomId)
                .forEach(p -> p.updateStatus(status));
    }

    private RecruitStatusStrategy findRecruitStrategy(RoomStatus status) {
        return strategies.stream()
                .filter(strategy -> strategy.support(status))
                .findFirst()
                .orElseThrow(() -> new RoomException(RoomExceptionInformation.ROOM_RECRUIT_STRATEGY_NOT_MATCH));
    }

    private void enterRoom(Room room, Member member) {
        participantSaveService.save(room, member);
    }

    private void startRoom(Room room) {
        room.startStopwatch();
        room.updateStatus(RoomStatus.PROGRESS);
    }

    private void endRoom(Room room) {
        room.endStopWatch();
        room.updateStatus(RoomStatus.COMPLETED);
    }

}
