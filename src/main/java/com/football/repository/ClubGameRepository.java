package com.football.repository;
import com.football.entites.ClubGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClubGameRepository extends JpaRepository<ClubGame,Long> {
}

