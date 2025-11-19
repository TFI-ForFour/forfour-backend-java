package com.forfour.domain.participant.controller;

import com.forfour.domain.participant.dto.response.MyParticipationDto;
import com.forfour.domain.participant.facade.ParticipantFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.forfour.domain.participant.controller.ResponseMessage.MY_PARTICIPATION;

@RestController
@RequiredArgsConstructor
public class ParticipantController implements ParticipantSwagger{

    private final ParticipantFacade facade;

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @GetMapping("/v1/my-participation")
    public ApiResponse<MyParticipationDto> checkMyParticipation() {
        MyParticipationDto response = facade.checkMyParticipation();
        return ApiResponse.response(HttpStatus.OK, MY_PARTICIPATION.getMessage(), response);
    }

}
