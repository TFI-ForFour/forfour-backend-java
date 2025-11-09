package com.forfour.domain.mission.service;

import com.forfour.domain.mission.entity.Mission;
import com.forfour.domain.mission.exception.MissionNotFoundException;
import com.forfour.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionGetService {

    private final MissionRepository missionRepository;

    public Mission getMission(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(MissionNotFoundException::new);
    }

}
