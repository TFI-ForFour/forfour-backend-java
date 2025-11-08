package com.forfour.domain.member.controller;

import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TestController {

    @AuthGuard(MemberGuard.class)
    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
