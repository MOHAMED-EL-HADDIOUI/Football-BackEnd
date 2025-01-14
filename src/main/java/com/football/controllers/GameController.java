package com.football.controllers;

import com.football.entites.Game;
import com.football.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
}
