package com.football.repository;
import com.football.entites.Appearance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearanceRepository extends JpaRepository<Appearance,String> {
    @Query("SELECT a FROM Appearance a WHERE a.player.playerId = :playerId")
    Page<Appearance> getListAppearancesByPlayer(@Param("playerId") Long playerId, Pageable pageable);
}
