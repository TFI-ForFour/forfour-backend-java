package com.forfour.domain.path.service;

import com.forfour.domain.path.entity.Path;
import com.forfour.domain.path.exception.PathExceptionInformation;
import com.forfour.domain.path.repository.PathRepository;
import com.forfour.global.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathGetService {

    private final PathRepository pathRepository;

    public Path getPath(Long pathId) {
        return pathRepository.findById(pathId)
                .orElseThrow(()-> BaseException.from(PathExceptionInformation.PATH_NOT_FOUND));
    }

    public Slice<Path> getPathScrollList(Pageable pageable) {
        return pathRepository.findPathScrollList(pageable);
    }

    public void validatePath(Long pathId) {
        if (!pathRepository.existsById(pathId)) {
            throw BaseException.from(PathExceptionInformation.PATH_NOT_FOUND);
        }
    }

}
