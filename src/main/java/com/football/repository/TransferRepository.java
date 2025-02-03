package com.football.repository;
import com.football.entites.Transfer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,Long> {
    @Query("select t from Transfer t where t.playerName like :kw")
    Page<Transfer> searchByPlayerName(@Param("kw") String keyword, Pageable pageable);
    @Query("select t from Transfer t where t.player.playerId =:playerId")
    Page<Transfer> searchByPlayer(@Param("playerId") Long playerId, Pageable pageable);
}
