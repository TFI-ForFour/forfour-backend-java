package com.forfour.domain.member.service;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSaveService {

    private final MemberRepository memberRepository;

    public Member join(Long kakaoId) {
        Member newMember = Member.from(kakaoId);
        return save(newMember);
    }

    private Member save(Member member) {
        return memberRepository.save(member);
    }

}
