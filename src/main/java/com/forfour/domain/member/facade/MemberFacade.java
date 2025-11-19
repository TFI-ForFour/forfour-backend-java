package com.forfour.domain.member.facade;

import com.forfour.domain.member.dto.request.NickNameUpdateDto;
import com.forfour.domain.member.dto.response.MemberDetailDto;
import com.forfour.domain.member.dto.response.MemberEnterDto;
import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.service.MemberGetService;
import com.forfour.domain.member.service.MemberSaveService;
import com.forfour.domain.participant.service.ParticipantGetService;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.service.RoomGetService;
import com.forfour.global.auth.context.MemberContext;
import com.forfour.global.auth.service.KakaoService;
import com.forfour.global.jwt.dto.JwtTokenResponseDto;
import com.forfour.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final KakaoService kakaoService;
    private final JwtService jwtService;
    private final MemberGetService memberGetService;
    private final MemberSaveService memberSaveService;
    private final RoomGetService roomGetService;
    private final ParticipantGetService participantGetService;

    public MemberEnterDto kakaoLogin(String authCode) {
        Long kakaoId = kakaoService.kakaoLogin(authCode);
        Optional<Member> findMember = memberGetService.getMemberByKakaoId(kakaoId);

        if (findMember.isEmpty()) {
            return registerNewMember(kakaoId);
        }

        return loginMember(findMember.get());
    }

    public MemberDetailDto readMemberInformation() {
        Long memberId = MemberContext.getMemberId();
        Member member = memberGetService.getMember(memberId);
        return MemberDetailDto.from(member);
    }

    @Transactional
    public MemberDetailDto updateNickname(NickNameUpdateDto dto) {
        Member member = memberGetService.getMember(MemberContext.getMemberId());
        String newName = dto.nickname();
        member.updateNickname(newName);

        List<Room> rooms = roomGetService.findByLeaderAndStatusNot(member);
        for (Room room : rooms) {
            room.updateLeaderName(newName);
        }

        return MemberDetailDto.from(member);
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
