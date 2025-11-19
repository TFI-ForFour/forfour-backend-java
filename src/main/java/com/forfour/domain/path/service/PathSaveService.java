package com.forfour.domain.path.service;

import com.forfour.domain.market.entity.Market;
import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.repository.PathRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathSaveService {

    private final PathRepository pathRepository;

    public Path save(PathSaveDto dto, Market startMarket, Market endMarket) {
        return pathRepository.save(Path.of(dto, startMarket, endMarket));
    }
}
