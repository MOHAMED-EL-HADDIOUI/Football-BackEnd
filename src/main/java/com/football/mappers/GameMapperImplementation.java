package com.football.mappers;

import com.football.dtos.ClubDTO;
import com.football.dtos.GameDTO;
import com.football.dtos.Game_DTO;
import com.football.entites.Club;
import com.football.entites.Game;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service

public class GameMapperImplementation {
    public GameDTO fromGame(Game game){
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(game,gameDTO);
        return gameDTO;
    }
    public Game fromGameDTO(GameDTO gameDTO){
        Game game = new Game();
        BeanUtils.copyProperties(gameDTO,game);
        return game;
    }
    public Game fromGame_DTO(Game_DTO game_DTO){
        Game game = new Game();
        BeanUtils.copyProperties(game_DTO,game,"awayClub","homeClub","competition");
        return game;
    }
    public void updateGameFromDTO(GameDTO gameDTO, Game game) {
        Game game1 = fromGameDTO(gameDTO);
        BeanUtils.copyProperties(game1, game,"gameId");
    }
}
