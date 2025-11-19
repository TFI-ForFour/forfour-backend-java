package com.forfour.domain.participant.service;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.repository.ParticipantRepository;
import com.forfour.domain.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantSaveService {

    private final ParticipantRepository participantRepository;

    public Participant save(Room room, Member member) {
        return participantRepository.save(Participant.of(room, member));
    }

}
