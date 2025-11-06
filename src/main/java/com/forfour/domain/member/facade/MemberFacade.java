package com.forfour.domain.member.facade;

import com.forfour.domain.member.dto.response.MemberEnterDto;
import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.service.MemberGetService;
import com.forfour.domain.member.service.MemberSaveService;
import com.forfour.global.auth.facade.KakaoService;
import com.forfour.global.jwt.dto.JwtTokenResponseDto;
import com.forfour.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final KakaoService kakaoService;
    private final JwtService jwtService;
    private final MemberGetService memberGetService;
    private final MemberSaveService memberSaveService;

    public MemberEnterDto kakaoLogin(String authCode) {
        Long kakaoId = kakaoService.kakaoLogin(authCode);
        Optional<Member> findMember = memberGetService.getMemberByKakaoId(kakaoId);

        if (findMember.isEmpty()) {
            return registerNewMember(kakaoId);
        }

        return loginMember(findMember.get());
    }

    private MemberEnterDto registerNewMember(Long kakaoId) {
        Member savedMember = memberSaveService.join(kakaoId);
        JwtTokenResponseDto jwtToken = jwtService.generateJwtToken(savedMember.getId(), savedMember.getRole());
        return MemberEnterDto.of(savedMember, jwtToken, true);
    }

    private MemberEnterDto loginMember(Member member) {
        JwtTokenResponseDto jwtToken = jwtService.generateJwtToken(member.getId(), member.getRole());
        return MemberEnterDto.of(member, jwtToken, false);
    }

}
