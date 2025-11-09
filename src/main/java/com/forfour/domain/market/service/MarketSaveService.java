package com.forfour.domain.market.service;

import com.forfour.domain.market.dto.request.MarketSaveDto;
import com.forfour.domain.market.entity.Market;
import com.forfour.domain.market.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MarketSaveService {

    private final MarketRepository marketRepository;

    @Transactional
    public Market save(MarketSaveDto dto) {
        return marketRepository.save(Market.from(dto));
    }

}
