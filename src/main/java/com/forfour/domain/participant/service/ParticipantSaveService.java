package com.forfour.domain.participant.service;

import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantSaveService {

    private final ParticipantRepository participantRepository;

    public Participant save(Long roomId, Long memberId) {
        return participantRepository.save(Participant.of(roomId, memberId));
    }

}
