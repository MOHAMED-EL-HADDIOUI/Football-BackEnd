package com.football.repository;
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
    @Query("select c from Game c where c.awayClubManagerName like :kw or c.homeClubManagerName like :kw")
    Page<Game> searchByAwayClubManagerNameOrHomeClubManagerName(@Param("kw") String keyword, Pageable pageable);
    @Query("select c from Game c where c.stadium like :kw")
    Page<Game> searchByStadium(@Param("kw") String keyword, Pageable pageable);
    @Query("select c from Game c where c.competition.name like :kw")
    Page<Game> searchByCompetition(@Param("kw") String keyword, Pageable pageable);
}
