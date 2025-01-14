package com.football.services;
import com.football.entites.GameLineup;
import com.football.repository.GameLineupRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GameLineupServiceImplementation implements GameLineupService {
    @Autowired
    @Order(1)
    GameLineupRepository gameLineupRepository;

    @Override
    public GameLineup saveGameLineup(GameLineup gameLineup) {
        return gameLineupRepository.save(gameLineup);
    }

    @Override
    public GameLineup getGameLineup(String Id_GameLineup) {
        return gameLineupRepository.getById(Id_GameLineup);
    }

    @Override
    public void deleteGameLineup(String Id_GameLineup) {
        gameLineupRepository.deleteById(Id_GameLineup);
    }

    @Override
    public List<GameLineup> getListGameLineups() {
        return gameLineupRepository.findAll();
    }
}
