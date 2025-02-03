package com.football.repository;
import com.football.entites.GameLineup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLineupRepository extends JpaRepository<GameLineup,String> {
    @Query("SELECT a FROM GameLineup a WHERE a.game.gameId = :gameId")
    Page<GameLineup> getListGameLineupsByGame(@Param("gameId") Long gameId, Pageable pageable);
}
