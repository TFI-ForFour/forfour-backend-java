package com.forfour.domain.room.dto.response;

import com.forfour.domain.participant.dto.response.ParticipantDetailDto;
import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.room.entity.Room;
import lombok.Builder;

import java.util.List;

@Builder
public record RoomWithParticipantsDto(
        RoomDetailDto roomDetail,
        List<ParticipantDetailDto> participantList
) {
    public static RoomWithParticipantsDto of(Room room, List<Participant> participantList) {
        List<ParticipantDetailDto> dataList = participantList.stream()
                .map(participant -> ParticipantDetailDto.from(participant.getMember()))
                .toList();

        return RoomWithParticipantsDto.builder()
                .roomDetail(RoomDetailDto.from(room))
                .participantList(dataList)
                .build();
    }
}
