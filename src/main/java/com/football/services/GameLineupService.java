package com.football.services;

import com.football.dtos.GameEventsDTO;
import com.football.dtos.GameLineupsDTO;
import com.football.entites.GameLineup;
import com.football.exceptions.GameEventNotFoundException;
import com.football.exceptions.GameLineuNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameLineupService {
    GameLineup saveGameLineup(GameLineup gameLineup);
    GameLineup getGameLineup(String Id_GameLineup);
    void deleteGameLineup(String Id_GameLineup);
    List<GameLineup> getListGameLineups();
    GameLineupsDTO getListGameLineupsByGame(Long gameId, int page) throws GameLineuNotFoundException;

}
