package com.forfour.domain.market.service;

import com.forfour.domain.market.entity.Market;
import com.forfour.domain.market.exception.MarketException;
import com.forfour.domain.market.exception.MarketExceptionInformation;
import com.forfour.domain.market.repository.MarketRepository;
import com.forfour.global.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarketGetService {

    private final MarketRepository marketRepository;

    public Market getMarketById(String uuid) {
        return marketRepository.findById(UUID.fromString(uuid))
                .orElseThrow(() -> new MarketException(MarketExceptionInformation.MARKET_NOT_FOUND));
    }

    public void validateMarket(String marketId) {
        if (!marketRepository.existsById(UUID.fromString(marketId))) {
            throw new MarketException(MarketExceptionInformation.MARKET_NOT_FOUND);
        }
    }

    public Market getMarket(String marketId) {
        return marketRepository.findById(UUID.fromString(marketId))
                .orElseThrow(() -> new MarketException(MarketExceptionInformation.MARKET_NOT_FOUND));
    }

}
