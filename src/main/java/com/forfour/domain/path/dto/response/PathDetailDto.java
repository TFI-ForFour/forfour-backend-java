package com.forfour.domain.path.dto.response;

import com.forfour.domain.path.entity.Path;
import lombok.Builder;

@Builder
public record PathDetailDto(
        Long pathId,
        String pathName,
        double distance,
        String startMarketName,
        String endMarketName,
        String startMarketId,
        String endMarketId,
        String pathImageUrl
) {
    public static PathDetailDto from(Path path) {
        return PathDetailDto.builder()
                .pathId(path.getId())
                .pathName(path.getPathName())
                .distance(path.getDistance())
                .startMarketName(path.getStartMarketName())
                .endMarketName(path.getEndMarketName())
                .startMarketId(path.getStartMarketId().toString())
                .endMarketId(path.getEndMarketId().toString())
                .pathImageUrl(path.getPathImageUrl())
                .build();
    }
}
