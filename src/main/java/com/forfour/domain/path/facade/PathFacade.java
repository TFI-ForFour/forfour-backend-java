package com.forfour.domain.path.facade;

import com.forfour.domain.market.service.MarketGetService;
import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.dto.response.PathDetailDto;
import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.service.PathSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathFacade {

    private final PathSaveService pathSaveService;
    private final MarketGetService marketGetService;

    public PathDetailDto save(PathSaveDto dto) {
        marketGetService.validateMarket(dto.startMarketId());
        marketGetService.validateMarket(dto.endMarketId());

        Path saved = pathSaveService.save(dto);
        return PathDetailDto.from(saved);
    }

}
