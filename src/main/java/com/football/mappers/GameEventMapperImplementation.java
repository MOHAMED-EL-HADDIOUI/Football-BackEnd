package com.football.mappers;

import com.football.dtos.GameEventDTO;
import com.football.entites.GameEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GameEventMapperImplementation {
    public GameEventDTO fromGameEvent(GameEvent gameEvent){
        GameEventDTO gameEventDTO = new GameEventDTO();
        BeanUtils.copyProperties(gameEvent,gameEventDTO);
        return gameEventDTO;
    }
    public GameEvent fromGameEventDTO(GameEventDTO gameEventDTO){
        GameEvent gameEvent = new GameEvent();
        BeanUtils.copyProperties(gameEventDTO,gameEvent);
        return gameEvent;
    }
    public void updateGameEventFromDTO(GameEventDTO gameEventDTO, GameEvent gameEvent) {
        GameEvent gameEvent1 = fromGameEventDTO(gameEventDTO);
        BeanUtils.copyProperties(gameEvent1, gameEvent,"gameEventId");
    }
}
