package com.forfour.domain.member.service;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.exception.MemberException;
import com.forfour.domain.member.exception.MemberExceptionInformation;
import com.forfour.domain.member.repository.MemberRepository;
import com.forfour.global.common.exception.BaseException;
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
                .orElseThrow(() -> new MemberException(MemberExceptionInformation.MEMBER_NOT_FOUND));
    }

}
