package com.forfour.domain.member.controller;

import com.forfour.domain.member.dto.request.MemberLoginDto;
import com.forfour.domain.member.dto.response.MemberDetailDto;
import com.forfour.domain.member.dto.response.MemberEnterDto;
import com.forfour.domain.member.facade.MemberFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.forfour.domain.member.controller.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberSwagger{

    private final MemberFacade memberFacade;

    @PostMapping("/auth/login/kakao")
    public ApiResponse<MemberEnterDto> kakaoLogin(
            @RequestBody MemberLoginDto dto
    ) {
        MemberEnterDto response = memberFacade.kakaoLogin(dto.code());
        if (response.isRegistered()) {
            return ApiResponse.response(HttpStatus.OK, MEMBER_REGISTER_SUCCESS.getMessage(), response);
        }

        return ApiResponse.response(HttpStatus.OK, MEMBER_LOGIN_SUCCESS.getMessage(), response);
    }

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @GetMapping("/v1/member")
    public ApiResponse<MemberDetailDto> readMemberInformation() {
        MemberDetailDto response = memberFacade.readMemberInformation();
        return ApiResponse.response(HttpStatus.OK, MEMBER_READ_SUCCESS.getMessage(), response);
    }

}
