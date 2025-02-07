package com.football.controllers;

import com.football.dtos.*;
import com.football.entites.Game;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.exceptions.GameNotFoundException;
import com.football.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/games/add")
    public GameDTO addPlayer(@RequestBody Game_DTO gameDto)
    {
        System.out.println("add game");
        System.out.println(gameDto.toString());
        GameDTO gameDTO = gameService.saveGame(gameDto);
        return gameDTO;
    }
    @PutMapping("/api/games/update")
    public GameDTO updatePlayer(@RequestBody  Game_DTO gameDto)
    {
        System.out.println("update game");
        System.out.println(gameDto.toString());
        GameDTO gameDTO = gameService.updateGame(gameDto);
        return gameDTO;
    }
    @DeleteMapping("/api/games/delete/{playerId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long gameId) {
        System.out.println("delete game");
        gameService.deleteGame(gameId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
