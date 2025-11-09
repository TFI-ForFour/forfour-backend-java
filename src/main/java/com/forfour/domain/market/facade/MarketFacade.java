package com.forfour.domain.market.facade;

import com.forfour.domain.market.dto.request.MarketSaveDto;
import com.forfour.domain.market.dto.response.MarketDetailDto;
import com.forfour.domain.market.entity.Market;
import com.forfour.domain.market.service.MarketSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketFacade {

    private final MarketSaveService marketSaveService;

    public MarketDetailDto save(MarketSaveDto dto) {
        Market saved = marketSaveService.save(dto);
        return MarketDetailDto.from(saved);
    }

}
