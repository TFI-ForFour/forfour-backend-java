package com.forfour.domain.market.controller;

import com.forfour.domain.market.dto.request.MarketSaveDto;
import com.forfour.domain.market.dto.response.MarketDetailDto;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "가게 등록")
public interface MarketSwagger {

    @Operation(description = "협력 가게 등록 API")
    public ApiResponse<MarketDetailDto> registerMarket(@RequestBody MarketSaveDto dto);

}
