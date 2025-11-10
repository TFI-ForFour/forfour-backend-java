package com.forfour.domain.room.service;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.exception.RoomLeaderNotEqualException;
import com.forfour.domain.room.exception.RoomNotFoundException;
import com.forfour.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    public Slice<Room> getActiveRooms(Pageable pageable) {
        return roomRepository.findActiveRooms(pageable);
    }

    public Slice<Room> getActiveRoomsWithStatus(RoomStatus status, Pageable pageable) {
        return roomRepository.findActiveRoomsWithStatus(status, pageable);
    }

}
