package com.forfour.domain.path.entity;

import com.forfour.domain.market.entity.Market;
import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.exception.PathNotMatchEndMarketException;
import com.forfour.domain.path.exception.PathNotMatchStartMarketException;
import com.forfour.domain.room.entity.Room;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Path extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pathName;

    private double distance;

    private UUID startMarketId;

    private UUID endMarketId;

    private String pathImageUrl;

    public static Path from(PathSaveDto dto) {
        return Path.builder()
                .pathName(dto.pathName())
                .distance(dto.distance())
                .startMarketId(UUID.fromString(dto.startMarketId()))
                .endMarketId(UUID.fromString(dto.endMarketId()))
                .pathImageUrl(dto.pathImageUrl())
                .build();
    }

    public void validateStartMarket(String uuid) {
        if (!startMarketId.equals(UUID.fromString(uuid))) {
            throw new PathNotMatchStartMarketException();
        }
    }

    public void validateEndMarket(String uuid) {
        if (!endMarketId.equals(UUID.fromString(uuid))) {
            throw new PathNotMatchEndMarketException();
        }
    }

}
