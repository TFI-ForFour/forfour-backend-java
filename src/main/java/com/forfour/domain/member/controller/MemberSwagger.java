package com.forfour.domain.member.controller;

import com.forfour.domain.member.dto.request.MemberLoginDto;
import com.forfour.domain.member.dto.response.MemberDetailDto;
import com.forfour.domain.member.dto.response.MemberEnterDto;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "회원")
public interface MemberSwagger {

    @Operation(description = "카카오 로그인", summary = "카카오 로그인")
    ApiResponse<MemberEnterDto> kakaoLogin(@RequestBody MemberLoginDto dto);

    @Operation(description = "회원 정보 조회", summary = "회원 정보 조회")
    ApiResponse<MemberDetailDto> readMemberInformation();
}
