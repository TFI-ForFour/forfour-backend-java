package com.forfour.domain.room.strategy;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;

public interface RecruitStatusStrategy {

    boolean support(RoomStatus roomStatus);

    void apply(Room room);

}
