package com.forfour.domain.participant.service;

import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.repository.ParticipantRepository;
import com.forfour.domain.room.entity.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantGetService {

    private final ParticipantRepository participantRepository;

    public List<Participant> getParticipants(Long roomId) {
        return participantRepository.findParticipantsByRoomId(roomId);
    }

    public Slice<Participant> findMyParticipatingRoom(Long memberId, Pageable pageable) {
        return participantRepository.findMyRoomsWithLeaderExceptStatus(memberId, RoomStatus.COMPLETED, pageable);
    }

    public Participant findMyProgressParticipation(Long memberId) {
        return participantRepository.findByMemberIdAndRoomStatus(memberId, RoomStatus.PROGRESS)
                .orElse(null);
    }

    public Slice<Participant> findMyParticipants(Long memberId, Pageable pageable) {
        return participantRepository.findByMemberId(memberId, pageable);
    }

}
