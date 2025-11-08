package com.forfour.domain.path.entity;

import com.forfour.domain.market.entity.Market;
import com.forfour.domain.room.entity.Room;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    private Long start_market_id;

    private Long end_market_id;

    private String pathImageUrl;

}
