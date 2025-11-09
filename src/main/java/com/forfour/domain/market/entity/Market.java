package com.forfour.domain.market.entity;

import com.forfour.domain.market.dto.request.MarketSaveDto;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Market extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String marketName;

    private String qrImageUrl;

    public static Market from(MarketSaveDto dto) {
        return Market.builder()
                .marketName(dto.marketName())
                .build();
    }

}
