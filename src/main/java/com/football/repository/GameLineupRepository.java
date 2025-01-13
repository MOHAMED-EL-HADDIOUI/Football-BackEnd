package com.football.repository;

import com.football.entites.GameLineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLineupRepository extends JpaRepository<GameLineup,String> {
}
