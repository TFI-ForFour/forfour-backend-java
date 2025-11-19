package com.forfour.domain.participant.repository;

import com.forfour.domain.participant.entity.Participant;
import com.forfour.domain.room.entity.RoomStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByRoomId(Long roomId);

    @Query("SELECT p " +
            "FROM Participant p JOIN FETCH p.member " +
            "WHERE p.room.id = :roomId")
    List<Participant> findParticipantsByRoomId(@Param("roomId") Long roomId);

    Optional<Participant> findByMemberIdAndRoomStatus(Long memberId, RoomStatus roomStatus);

    Slice<Participant> findByMemberId(Long memberId, Pageable pageable);

    @Query(value = """
            select p
            from Participant p
            join fetch p.room r
            join fetch r.leader l
            where p.member.id = :memberId
              and p.roomStatus <> :excludedStatus
            order by r.startAt asc
            """)
    Slice<Participant> findMyRoomsWithLeaderExceptStatus(
            @Param("memberId") Long memberId,
            @Param("excludedStatus") RoomStatus excludedStatus,
            Pageable pageable
    );

}
