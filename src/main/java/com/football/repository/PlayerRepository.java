package com.football.repository;
import com.football.entites.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("select c from Player c where c.name like :kw")
    Page<Player> searchByName(@Param("kw") String keyword, Pageable pageable);
    @Query("select c from Player c where c.competition.name like :kw")
    Page<Player> searchByCompetition(@Param("kw") String keyword, Pageable pageable);
    @Query("select c from Player c where c.currentClub.name like :kw")
    Page<Player> searchByCurrentClub(@Param("kw") String keyword, Pageable pageable);
    @Query("select c from Player c where c.position like :kw")
    Page<Player> searchByPosition(@Param("kw") String keyword, Pageable pageable);
    @Query("SELECT p FROM Player p WHERE p.currentClub.clubId = :idClub")
    Page<Player> getListPlayersByCurrentClub(@Param("idClub") Long idClub, Pageable pageable);

}
