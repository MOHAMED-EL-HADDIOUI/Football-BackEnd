package com.football.mappers;

import com.football.dtos.GameEventDTO;
import com.football.dtos.GameLineupDTO;
import com.football.entites.GameEvent;
import com.football.entites.GameLineup;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GameLineupMapperImplementation {
    public GameLineupDTO fromGameLineup(GameLineup gameLineup){
        GameLineupDTO gameLineupDTO = new GameLineupDTO();
        BeanUtils.copyProperties(gameLineup,gameLineupDTO);
        return gameLineupDTO;
    }
    public GameLineup fromGameLineupDTO(GameLineupDTO gameLineupDTO){
        GameLineup gameLineup = new GameLineup();
        BeanUtils.copyProperties(gameLineupDTO,gameLineup);
        return gameLineup;
    }
    public void updategameLineupFromDTO(GameLineupDTO gameLineupDTO, GameLineup gameLineup) {
        GameLineup gameLineup1 = fromGameLineupDTO(gameLineupDTO);
        BeanUtils.copyProperties(gameLineup1, gameLineup,"gameLineupsId");
    }
}
