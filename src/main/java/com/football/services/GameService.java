package com.football.services;

import com.football.dtos.ClubsDTO;
import com.football.dtos.GameDTO;
import com.football.dtos.Game_DTO;
import com.football.dtos.GamesDTO;
import com.football.entites.Game;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.GameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    GameDTO saveGame(Game_DTO game_Dto);
    GameDTO updateGame(Game_DTO game_Dto);


    Game getGame(Long Id_Game);
    void deleteGame(Long Id_Game);
    List<Game> getListGames();
    GamesDTO searchByHomeClubNameOrAwayClubName(String name, int page) throws GameNotFoundException;
    GamesDTO searchByAwayClubManagerNameOrHomeClubManagerName(String name, int page) throws GameNotFoundException;
    GamesDTO searchByStadium(String name, int page) throws GameNotFoundException;
    GamesDTO searchByCompetition(String name, int page) throws GameNotFoundException;

}
