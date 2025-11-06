package com.forfour.global.auth.context;


import com.forfour.global.jwt.dto.JwtTokenClaimsDto;

public class MemberContext {

    private static final ThreadLocal<JwtTokenClaimsDto> currentMemberContext = new ThreadLocal<JwtTokenClaimsDto>();

    public static void setCurrentMemberClaims(JwtTokenClaimsDto memberClaims) {
        currentMemberContext.set(memberClaims);
    }

    public static void clear() {
        currentMemberContext.remove();
    }

    public static Long getMemberId() {
        return currentMemberContext.get().memberId();
    }

}
