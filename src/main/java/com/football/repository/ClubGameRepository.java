package com.football.repository;
import com.football.entites.ClubGame;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
@Repository
public interface ClubGameRepository extends JpaRepository<ClubGame,Long> {
    @Query("SELECT a FROM ClubGame a WHERE a.game.gameId = :gameId")
    Page<ClubGame> getListClubGamesByGame(@Param("gameId") Long gameId, Pageable pageable);
}

