package com.forfour.domain.room.service;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.exception.RoomException;
import com.forfour.domain.room.exception.RoomExceptionInformation;
import com.forfour.domain.room.repository.RoomRepository;
import com.forfour.global.common.exception.BaseException;
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
                .orElseThrow(() -> new RoomException(RoomExceptionInformation.ROOM_NOT_FOUND));
    }

    public Room getRoomUsingLock(Long roomId) {
        return roomRepository.findByIdWithPessimisticLock(roomId)
                .orElseThrow(() -> new RoomException(RoomExceptionInformation.ROOM_NOT_FOUND));
    }

    public Slice<Room> getActiveRooms(Pageable pageable) {
        return roomRepository.findActiveRooms(pageable);
    }

    public Slice<Room> getActiveRoomsWithStatus(RoomStatus status, Pageable pageable) {
        return roomRepository.findActiveRoomsWithStatus(status, pageable);
    }

}
