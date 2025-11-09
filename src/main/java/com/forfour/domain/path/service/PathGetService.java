package com.forfour.domain.path.service;

import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.exception.PathNotFoundException;
import com.forfour.domain.path.repository.PathRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathGetService {

    private final PathRepository pathRepository;

    public Path getPath(Long pathId) {
        return pathRepository.findById(pathId)
                .orElseThrow(PathNotFoundException::new);
    }
}
