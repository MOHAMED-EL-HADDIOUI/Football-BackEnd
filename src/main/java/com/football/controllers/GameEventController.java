package com.football.controllers;

import com.football.dtos.ClubGamesDTO;
import com.football.dtos.GameEventsDTO;
import com.football.exceptions.ClubGameNotFoundException;
import com.football.exceptions.GameEventNotFoundException;
import com.football.services.ClubGameService;
import com.football.services.GameEventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameEventController {
    private GameEventService gameEventService;

    public GameEventController(GameEventService gameEventService) {
        this.gameEventService = gameEventService;
    }
    @GetMapping("/api/gameevents/game")
    public GameEventsDTO getListGameEventsByPlayer(@RequestParam(name = "gameId", defaultValue = "") Long gameId, @RequestParam(name = "page", defaultValue = "0") int page) throws GameEventNotFoundException {
        GameEventsDTO gameEventsDTO = this.gameEventService.getListGameEventsByGame(gameId,page);
        return gameEventsDTO;
    }
}
