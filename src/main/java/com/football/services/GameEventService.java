package com.football.services;

import com.football.dtos.ClubGamesDTO;
import com.football.dtos.GameEventsDTO;
import com.football.entites.GameEvent;
import com.football.exceptions.ClubGameNotFoundException;
import com.football.exceptions.GameEventNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameEventService {
    GameEvent saveGameEvent(GameEvent gameEvent);
    GameEvent getGameEvent(String Id_GameEvent);
    void deleteGameEvent(String Id_GameEvent);
    List<GameEvent> getListGameEvents();
    GameEventsDTO getListGameEventsByGame(Long playerId, int page) throws GameEventNotFoundException;

}
