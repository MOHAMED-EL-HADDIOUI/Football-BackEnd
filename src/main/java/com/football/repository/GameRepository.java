package com.football.repository;

import com.football.entites.Club;
import com.football.entites.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    @Query("select c from Game c where c.homeClubName like :kw or c.awayClubName like :kw")
    Page<Game> searchByHomeClubNameOrAwayClubName(@Param("kw") String keyword, Pageable pageable);
}
