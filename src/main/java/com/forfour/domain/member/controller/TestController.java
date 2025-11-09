package com.forfour.domain.member.controller;

import com.forfour.domain.member.entity.Role;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.context.MemberContext;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.jwt.dto.JwtTokenResponseDto;
import com.forfour.global.jwt.service.JwtService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
