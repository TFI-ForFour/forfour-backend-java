package com.forfour.domain.room.facade;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.service.MemberGetService;
import com.forfour.domain.participant.service.ParticipantSaveService;
import com.forfour.domain.path.service.PathGetService;
import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.service.RoomGetService;
import com.forfour.domain.room.service.RoomSaveService;
import com.forfour.global.auth.context.MemberContext;
import lombok.RequiredArgsConstructor;
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
        Room savedRoom = roomSaveService.save(dto, leader.getId());
        saveLeader(savedRoom.getId(), leader.getId());

        return RoomDetailDto.from(savedRoom, leader);
    }

    @Transactional
    public void participateRoom(Long roomId) {
        Long participantId = MemberContext.getMemberId();

        Room room = roomGetService.getRoomUsingLock(roomId);
        room.checkParticipate();

        participantSaveService.save(roomId, participantId);
        room.increaseMemberCount();
    }

    private void saveLeader(Long roomId, Long leaderId) {
        participantSaveService.save(roomId, leaderId);
    }

}
