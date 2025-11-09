package com.forfour.domain.path.facade;

import com.forfour.domain.market.service.MarketGetService;
import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.dto.response.PathDetailDto;
import com.forfour.domain.path.dto.response.SlicePathDto;
import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.service.PathGetService;
import com.forfour.domain.path.service.PathSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathFacade {

    private final PathSaveService pathSaveService;
    private final PathGetService pathGetService;
    private final MarketGetService marketGetService;

    public PathDetailDto save(PathSaveDto dto) {
        marketGetService.validateMarket(dto.startMarketId());
        marketGetService.validateMarket(dto.endMarketId());

        Path saved = pathSaveService.save(dto);
        return PathDetailDto.from(saved);
    }

    public PathDetailDto readPath(Long pathId) {
        Path path = pathGetService.getPath(pathId);
        return PathDetailDto.from(path);
    }

}
