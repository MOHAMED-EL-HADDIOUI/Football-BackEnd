package com.football.controllers;

import com.football.dtos.GameEventsDTO;
import com.football.dtos.GameLineupsDTO;
import com.football.exceptions.GameEventNotFoundException;
import com.football.exceptions.GameLineuNotFoundException;
import com.football.services.GameEventService;
import com.football.services.GameLineupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GameLineupController {
    private GameLineupService gameLineupService;

    public GameLineupController(GameLineupService gameLineupService) {
        this.gameLineupService = gameLineupService;
    }
    @GetMapping("/api/gamelineups/game")
    public GameLineupsDTO getListGameLineupsByPlayer(@RequestParam(name = "gameId", defaultValue = "") Long gameId, @RequestParam(name = "page", defaultValue = "0") int page) throws GameLineuNotFoundException {
        GameLineupsDTO gameLineupsDTO = this.gameLineupService.getListGameLineupsByGame(gameId,page);
        return gameLineupsDTO;
    }
}
