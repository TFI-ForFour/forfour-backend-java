package com.forfour.domain.room.entity;

public enum Mission {
    PLOGGING,
    DELIVERY,
    PARK,
    NO_MISSION,
    ;

    public static Mission value(String mission) {
        if (mission == null || mission.isBlank()) {
            return NO_MISSION;
        }
        return Mission.valueOf(mission);
    }

}
