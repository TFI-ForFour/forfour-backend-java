package com.forfour.domain.room.facade;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.service.MemberGetService;
import com.forfour.domain.participant.service.ParticipantSaveService;
import com.forfour.domain.path.service.PathGetService;
import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.dto.response.SliceRoomDto;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.service.RoomGetService;
import com.forfour.domain.room.service.RoomSaveService;
import com.forfour.global.auth.context.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomSaveService roomSaveService;
    private final RoomGetService roomGetService;
    private final ParticipantSaveService participantSaveService;
    private final PathGetService pathGetService;
    private final MemberGetService memberGetService;

    public RoomDetailDto createRoom(RoomSaveDto dto) {
        pathGetService.validatePath(dto.pathId());

        Member leader = memberGetService.getMember(MemberContext.getMemberId());
        Room savedRoom = roomSaveService.save(dto, leader);
        enterRoom(savedRoom.getId(), leader.getId());

        return RoomDetailDto.of(savedRoom, leader);
    }

    @Transactional
    public void participateRoom(Long roomId) {
        Room room = roomGetService.getRoomUsingLock(roomId);
        room.checkParticipate();

        Long participantId = MemberContext.getMemberId();
        enterRoom(room.getId(), participantId);
        room.increaseMemberCount();
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

    private void enterRoom(Long roomId, Long leaderId) {
        participantSaveService.save(roomId, leaderId);
    }

}
