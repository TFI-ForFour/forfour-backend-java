package com.forfour.domain.room.dto.response;

import com.forfour.domain.room.entity.Room;
import com.forfour.global.common.dto.PageableDto;
import lombok.Builder;
import org.springframework.data.domain.Slice;

import java.util.List;

@Builder
public record SliceRoomDto(
        List<RoomDetailDto> dataList,
        PageableDto pageable
) {
    public static SliceRoomDto from(Slice<Room> slice) {
        List<RoomDetailDto> dataList = slice.map(RoomDetailDto::from)
                .toList();

        return SliceRoomDto.builder()
                .dataList(dataList)
                .pageable(PageableDto.from(slice))
                .build();
    }
}
