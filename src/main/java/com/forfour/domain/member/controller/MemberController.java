package com.forfour.domain.member.controller;

import com.forfour.domain.member.dto.request.MemberLoginDto;
import com.forfour.domain.member.dto.response.MemberEnterDto;
import com.forfour.domain.member.facade.MemberFacade;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.forfour.domain.member.controller.ResponseMessage.MEMBER_LOGIN_SUCCESS;
import static com.forfour.domain.member.controller.ResponseMessage.MEMBER_REGISTER_SUCCESS;

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

}
