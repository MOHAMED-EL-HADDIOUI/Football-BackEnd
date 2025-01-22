package com.football.repository;

import com.football.entites.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("select c from Player c where c.name like :kw")
    Page<Player> searchByName(@Param("kw") String keyword, Pageable pageable);
}
