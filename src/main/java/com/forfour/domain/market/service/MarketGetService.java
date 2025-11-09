package com.forfour.domain.market.service;

import com.forfour.domain.market.entity.Market;
import com.forfour.domain.market.exception.MarketNotFoundException;
import com.forfour.domain.market.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarketGetService {

    private final MarketRepository marketRepository;

    public void validateMarket(String marketId) {
        if (!marketRepository.existsById(UUID.fromString(marketId))) {
            throw new MarketNotFoundException();
        }
    }

    public Market getMarket(String marketId) {
        return marketRepository.findById(UUID.fromString(marketId))
                .orElseThrow(MarketNotFoundException::new);
    }

}
