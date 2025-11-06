package com.forfour.global.auth.facade;

import com.forfour.domain.member.service.MemberGetService;
import com.forfour.global.auth.kakao.dto.KaKaoDTO;
import com.forfour.global.auth.kakao.utils.KakaoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        KaKaoDTO.KakaoAccessToken kakaoAccessToken = kakaoUtil.reqeustKakaoToken(authCode);
        KaKaoDTO.KakaoUserInfoResponse userInfo = kakaoUtil.requestKakaoProfile(kakaoAccessToken.access_token());
        return userInfo;
    }

}
