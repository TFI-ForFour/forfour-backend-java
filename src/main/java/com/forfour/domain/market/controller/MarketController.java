package com.forfour.domain.market.controller;

import com.forfour.domain.market.dto.request.MarketSaveDto;
import com.forfour.domain.market.dto.response.MarketDetailDto;
import com.forfour.domain.market.facade.MarketFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.forfour.domain.market.controller.ResponseMessage.MARKET_CREATED;


@RestController
@RequiredArgsConstructor
public class MarketController implements MarketSwagger{

    private final MarketFacade facade;

    @AuthGuard({AdminGuard.class})
    @PostMapping("/v1/market")
    public ApiResponse<MarketDetailDto> registerMarket(
            @RequestBody MarketSaveDto dto
    ) {
        MarketDetailDto response = facade.save(dto);
        return ApiResponse.response(HttpStatus.OK, MARKET_CREATED.getMessage(), response);
    }

}
