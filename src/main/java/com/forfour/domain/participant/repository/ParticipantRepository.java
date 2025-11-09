package com.forfour.domain.participant.repository;

import com.forfour.domain.participant.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByRoomId(Long roomId);

    @Query("SELECT p " +
            "FROM Participant p JOIN FETCH p.member" +
            " WHERE p.roomId = :roomId")
    List<Participant> findParticipantsByRoomId(@Param("roomId") Long roomId);
}
