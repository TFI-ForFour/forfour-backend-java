package com.forfour.domain.market.dto.response;

import com.forfour.domain.market.entity.Market;
import lombok.Builder;

@Builder
public record MarketDetailDto(
        String uuid,
        String marketName,
        String qrImageUrl
) {
    public static MarketDetailDto from(Market market) {
        return MarketDetailDto.builder()
                .uuid(market.getId().toString())
                .marketName(market.getMarketName())
                .qrImageUrl(market.getQrImageUrl())
                .build();
    }
}
