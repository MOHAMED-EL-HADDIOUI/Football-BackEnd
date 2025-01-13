package com.football.repository;

import com.football.entites.PlayerValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerValuationRepository extends JpaRepository<PlayerValuation,Long> {
}
