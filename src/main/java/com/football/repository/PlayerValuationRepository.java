package com.football.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.football.entites.PlayerValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerValuationRepository extends JpaRepository<PlayerValuation,Long> {
    @Query("SELECT p FROM PlayerValuation p WHERE p.player.playerId = :playerId")
    Page<PlayerValuation> getListPlayerValuationsByPlayer(@Param("playerId") Long playerId, Pageable pageable);
}
