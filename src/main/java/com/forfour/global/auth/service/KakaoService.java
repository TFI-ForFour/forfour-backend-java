package com.forfour.global.auth.service;

import com.forfour.global.auth.kakao.dto.KaKaoDTO;
import com.forfour.global.auth.kakao.utils.KakaoUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoUtil kakaoUtil;

    public Long kakaoLogin(String authCode) {
        KaKaoDTO.KakaoUserInfoResponse userInfo = getKakaoUserInfoByAuthCode(authCode);
        Long kakaoId = userInfo.id();
        return kakaoId;
    }

    private KaKaoDTO.KakaoUserInfoResponse getKakaoUserInfoByAuthCode(String authCode) {
        log.info("카카오 토큰 조회 API 호출");
        KaKaoDTO.KakaoAccessToken kakaoAccessToken = kakaoUtil.reqeustKakaoToken(authCode);
        log.info("카카오 토큰으로 유저 정보 조회 API 호출");
        KaKaoDTO.KakaoUserInfoResponse userInfo = kakaoUtil.requestKakaoProfile(kakaoAccessToken.access_token());
        log.info("유저 정보 조회 API 호출 성공");
        return userInfo;
    }

}
