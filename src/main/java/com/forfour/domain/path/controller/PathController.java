package com.forfour.domain.path.controller;

import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.dto.response.PathDetailDto;
import com.forfour.domain.path.dto.response.SlicePathDto;
import com.forfour.domain.path.facade.PathFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.forfour.domain.path.controller.ResponseMessage.*;

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

    @AuthGuard(MemberGuard.class)
    @GetMapping("/v1/path/{pathId}")
    public ApiResponse<PathDetailDto> readWalkingPath(
            @PathVariable Long pathId
    ) {
        PathDetailDto response = facade.readPath(pathId);
        return ApiResponse.response(HttpStatus.OK, SINGLE_PATH_READ.getMessage(), response);
    }

    @AuthGuard(MemberGuard.class)
    @GetMapping("/v1/path-list")
    public ApiResponse<SlicePathDto> scrollWalkingPath(
            @RequestParam int pageSize,
            @RequestParam int pageNum
    ) {
        SlicePathDto response = facade.readPathScrollList(pageSize, pageNum);
        return ApiResponse.response(HttpStatus.OK, PATH_SCROLL_LIST_READ.getMessage(), response);
    }

}
