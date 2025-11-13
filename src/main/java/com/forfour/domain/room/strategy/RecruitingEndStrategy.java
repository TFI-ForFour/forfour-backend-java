package com.forfour.domain.room.strategy;

import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.exception.RoomExceptionInformation;
import com.forfour.global.common.exception.BaseException;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class RecruitingEndStrategy implements RecruitStatusStrategy {
    @Override
    public boolean support(RoomStatus roomStatus) {
        return roomStatus.equals(RoomStatus.RECRUITMENT_ENDED);
    }

    @Override
    public void apply(Room room) {
        validateUpdateCondition(room);
        updateRoomStatus(room);
    }

    private void validateUpdateCondition(Room room) {
        RoomStatus roomStatus = filterRoomStrategy(room);
        if (roomStatus != null) {
            throw BaseException.from(RoomExceptionInformation.ROOM_DO_NOT_UPDATE_STATUS);
        }
        room.validateMinimumMember();
    }

    private void updateRoomStatus(Room room) {
        room.updateStatus(RoomStatus.RECRUITMENT_ENDED);
    }

    private RoomStatus filterRoomStrategy(Room room) {
        return Stream.of(RoomStatus.CANCELED, RoomStatus.PROGRESS, RoomStatus.COMPLETED, RoomStatus.RECRUITMENT_ENDED)
                .filter(room::checkStatus)
                .findFirst()
                .orElse(null);
    }

}
