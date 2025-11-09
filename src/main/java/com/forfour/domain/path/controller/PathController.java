package com.forfour.domain.path.controller;

import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.dto.response.PathDetailDto;
import com.forfour.domain.path.facade.PathFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.forfour.domain.path.controller.ResponseMessage.PATH_CREATED;

@RestController
@RequiredArgsConstructor
public class PathController implements PathSwagger{

    private final PathFacade facade;

    @AuthGuard(AdminGuard.class)
    @PostMapping("/v1/path")
    public ApiResponse<PathDetailDto> createWalkingPath(
            @RequestBody @Validated PathSaveDto dto
    ) {
        PathDetailDto response = facade.save(dto);
        return ApiResponse.response(HttpStatus.OK, PATH_CREATED.getMessage(), response);
    }

}
