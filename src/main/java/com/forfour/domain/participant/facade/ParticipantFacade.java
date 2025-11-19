package com.forfour.domain.participant.facade;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.participant.service.ParticipantGetService;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.event.RoomEndEvent;
import com.forfour.domain.room.event.RoomStartEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantFacade {

    private final ParticipantGetService participantGetService;

    @Transactional
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void updateWalkingStatus(RoomStartEvent event) {
        Long roomId = event.roomId();
        RoomStatus status = event.status();
        participantGetService.getParticipants(roomId)
                .forEach(p -> p.updateStatus(status));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void endWalking(RoomEndEvent event) {
        Long roomId = event.roomId();

        List<Participant> participants = participantGetService.getParticipants(roomId);
        for (Participant participant : participants) {
            participant.updateStatus(event.status());
            Member member = participant.getMember();
            member.updateWalkData(event.distance());
        }
    }

}
