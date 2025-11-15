package com.forfour.domain.participant.facade;

import com.forfour.domain.participant.service.ParticipantGetService;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.event.RoomStartEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

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

}
