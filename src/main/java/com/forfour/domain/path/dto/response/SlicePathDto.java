package com.forfour.domain.path.dto.response;

import com.forfour.domain.path.entity.Path;
import com.forfour.global.common.dto.PageableDto;
import lombok.Builder;
import org.springframework.data.domain.Slice;

import java.util.List;

@Builder
public record SlicePathDto(
        List<PathDetailDto> dataList,
        PageableDto pageable
) {
    public static SlicePathDto from(Slice<Path> slice) {
        List<PathDetailDto> dataList = slice.map(PathDetailDto::from)
                .toList();

        return SlicePathDto.builder()
                .dataList(dataList)
                .pageable(PageableDto.from(slice))
                .build();
    }
}
