package com.forfour.global.auth.kakao.utils;


import com.forfour.global.auth.kakao.dto.KaKaoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
public class KakaoUtil {

    @Value("${forfour.auth.kakao.client}")
    private String kakaoClient;

    @Value("${forfour.auth.kakao.redirect}")
    private String kakaoRedirect;

    @Value("${forfour.auth.kakao.tokenUri}")
    private String kakaoTokenUri;

    @Value("${forfour.auth.kakao.userProfile}")
    private String kakaoUserProfileUri;

    @Value("${forfour.auth.kakao.clientSecret}")
    private String clientSecret;

    private final RestClient restClient = RestClient.create();

    public KaKaoDTO.KakaoAccessToken reqeustKakaoToken(String authCode){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoClient);
        params.add("redirect_url", kakaoRedirect);
        params.add("client_secret", clientSecret);
        params.add("code", authCode);

        return restClient.post()
                .uri(kakaoTokenUri)
                .body(params)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve()
                .body(KaKaoDTO.KakaoAccessToken.class);
    }

    public KaKaoDTO.KakaoUserInfoResponse requestKakaoProfile(String Token){
        return restClient.get()
                .uri(kakaoUserProfileUri)
                .header("Authorization", "Bearer " + Token)
                .retrieve()
                .body(KaKaoDTO.KakaoUserInfoResponse.class);
    }
}

