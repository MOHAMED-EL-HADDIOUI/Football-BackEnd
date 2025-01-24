package com.football.controllers;

import com.football.dtos.CompetitionsDTO;
import com.football.dtos.GamesDTO;
import com.football.entites.Game;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.exceptions.GameNotFoundException;
import com.football.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Objects;

@RestController
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/api/games/{game_id}")
    public Game getAppearance(@PathVariable Long game_id){
        Game game = gameService.getGame(game_id);
        return game;
    }
    @GetMapping("/api/games/")
    public List<Game> getAppearances(){
        return  gameService.getListGames();
    }
    @GetMapping("/api/games/search")
    public GamesDTO getGamesByName(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "criteria", defaultValue = "Club") String criteria) throws GameNotFoundException {
        GamesDTO gamesDTO = new GamesDTO();
        if(Objects.equals(criteria, "Club"))
        {
            gamesDTO = gameService.searchByHomeClubNameOrAwayClubName("%" + keyword + "%", page);
        }
        else if(Objects.equals(criteria, "Manager"))
        {
            gamesDTO = gameService.searchByAwayClubManagerNameOrHomeClubManagerName("%" + keyword + "%", page);

        }
        else if(Objects.equals(criteria, "Competition"))
        {
            gamesDTO = gameService.searchByCompetition("%" + keyword + "%", page);
        }
        else
        {
            gamesDTO = gameService.searchByStadium("%" + keyword + "%", page);
        }

        return gamesDTO;
    }
}
