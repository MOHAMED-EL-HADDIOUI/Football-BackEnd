package com.football.repository;
import com.football.entites.GameEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameEventRepository extends JpaRepository<GameEvent,String> {
    @Query("SELECT a FROM GameEvent a WHERE a.game.gameId = :gameId")
    Page<GameEvent> getListGameEventsByGame(@Param("gameId") Long gameId, Pageable pageable);
}
