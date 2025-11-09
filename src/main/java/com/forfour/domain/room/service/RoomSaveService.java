package com.forfour.domain.room.service;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomSaveService {

    private final RoomRepository roomRepository;

    public Room save(RoomSaveDto dto, Member leader) {
        return roomRepository.save(Room.of(dto, leader));
    }

}
