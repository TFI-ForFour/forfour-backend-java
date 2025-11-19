package com.forfour.domain.room.repository;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Room r WHERE r.id = :id")
    Optional<Room> findByIdWithPessimisticLock(@Param("id") Long id);

    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.leader " +
            "WHERE r.isActive = true " +
            "AND r.status = :status")
    Slice<Room> findActiveRoomsWithStatus(
            @Param("status") RoomStatus roomStatus,
            Pageable pageable
    );

    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.leader " +
            "WHERE r.isActive = true ")
    Slice<Room> findActiveRooms(
            Pageable pageable
    );

    List<Room> findByLeader(Member leader);

    List<Room> findByLeaderAndStatusNot(Member leader, RoomStatus status);

}
