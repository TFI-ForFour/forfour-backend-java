package com.forfour.domain.room.strategy;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.exception.RoomException;
import com.forfour.domain.room.exception.RoomExceptionInformation;
import com.forfour.global.common.exception.BaseException;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class RecruitingStrategy implements RecruitStatusStrategy {

    @Override
    public boolean support(RoomStatus roomStatus) {
        return roomStatus.equals(RoomStatus.RECRUITING);
    }

    @Override
    public void apply(Room room) {
        validateUpdateCondition(room);
        updateRoomStatus(room);
    }

    private void validateUpdateCondition(Room room) {
        RoomStatus roomStatus = filterRoomStrategy(room);
        if (roomStatus != null) {
            throw new RoomException(RoomExceptionInformation.ROOM_DO_NOT_UPDATE_STATUS);
        }
    }

    private RoomStatus filterRoomStrategy(Room room) {
        return Stream.of(RoomStatus.RECRUITING, RoomStatus.CANCELED, RoomStatus.PROGRESS, RoomStatus.COMPLETED)
                .filter(room::checkStatus)
                .findFirst()
                .orElse(null);
    }

    private void updateRoomStatus(Room room) {
        room.updateStatus(RoomStatus.RECRUITING);
    }

}
