package com.forfour.domain.room.service;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.exception.RoomNotFoundException;
import com.forfour.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomGetService {

    private final RoomRepository roomRepository;

    public Room getRoom(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(RoomNotFoundException::new);
    }

    public Room getRoomUsingLock(Long roomId) {
        return roomRepository.findByIdWithPessimisticLock(roomId)
                .orElseThrow(RoomNotFoundException::new);
    }

}
