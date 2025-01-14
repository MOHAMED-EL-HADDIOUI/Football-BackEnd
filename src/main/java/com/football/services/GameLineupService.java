package com.football.services;

import com.football.entites.GameLineup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameLineupService {
    GameLineup saveGameLineup(GameLineup gameLineup);
    GameLineup getGameLineup(String Id_GameLineup);
    void deleteGameLineup(String Id_GameLineup);
    List<GameLineup> getListGameLineups();
}
