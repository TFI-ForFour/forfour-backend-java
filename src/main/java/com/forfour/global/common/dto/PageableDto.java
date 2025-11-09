package com.forfour.global.common.dto;

import lombok.Builder;
import org.springframework.data.domain.Slice;

@Builder
public record PageableDto(
        int pageSize,
        int pageNum,
        int numberOfElements,
        boolean isLast
) {
    public static <T> PageableDto from(Slice<T> slice) {
        return PageableDto.builder()
                .pageSize(slice.getSize())
                .pageNum(slice.getNumber())
                .numberOfElements(slice.getNumberOfElements())
                .isLast(slice.isLast())
                .build();
    }
}
