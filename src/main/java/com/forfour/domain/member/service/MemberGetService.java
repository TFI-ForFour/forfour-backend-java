package com.forfour.domain.member.service;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.exception.MemberNotFoundException;
import com.forfour.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberGetService {

    private final MemberRepository memberRepository;

    public Optional<Member> getMemberByKakaoId(Long kakaoId) {
        return memberRepository.findByKakaoId(kakaoId);
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
    }

}
