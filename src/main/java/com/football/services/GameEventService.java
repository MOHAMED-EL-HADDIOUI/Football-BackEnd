package com.football.services;

import com.football.entites.GameEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameEventService {
    GameEvent saveGameEvent(GameEvent gameEvent);
    GameEvent getGameEvent(String Id_GameEvent);
    void deleteGameEvent(String Id_GameEvent);
    List<GameEvent> getListGameEvents();
}
