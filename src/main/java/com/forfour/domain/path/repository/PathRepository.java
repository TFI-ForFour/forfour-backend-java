package com.forfour.domain.path.repository;

import com.forfour.domain.path.entity.Path;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {

    @Query("SELECT p FROM Path p")
    Slice<Path> findPathScrollList(Pageable pageable);

}
