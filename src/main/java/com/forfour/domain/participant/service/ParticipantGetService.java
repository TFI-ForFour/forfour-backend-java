package com.forfour.domain.participant.service;

import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.repository.ParticipantRepository;
import com.forfour.domain.room.entity.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantGetService {

    private final ParticipantRepository participantRepository;

    public List<Participant> getParticipants(Long roomId) {
        return participantRepository.findParticipantsByRoomId(roomId);
    }

    public Participant findMyProgressParticipation(Long memberId) {
        return participantRepository.findByMemberIdAndRoomStatus(memberId, RoomStatus.PROGRESS)
                .orElse(null);
    }

}
