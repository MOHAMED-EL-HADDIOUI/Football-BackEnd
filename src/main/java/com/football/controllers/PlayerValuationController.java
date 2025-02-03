package com.football.controllers;

import com.football.dtos.GameLineupsDTO;
import com.football.dtos.PlayerValuationsDTO;
import com.football.exceptions.GameLineuNotFoundException;
import com.football.exceptions.PlayerValuationNotFoundException;
import com.football.services.GameLineupService;
import com.football.services.PlayerValuationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerValuationController {
    private PlayerValuationService playerValuationService;

    public PlayerValuationController(PlayerValuationService playerValuationService) {
        this.playerValuationService = playerValuationService;
    }
    @GetMapping("/api/playervaluations/player")
    public PlayerValuationsDTO getListGameLineupsByPlayer(@RequestParam(name = "playerId", defaultValue = "") Long playerId, @RequestParam(name = "page", defaultValue = "0") int page) throws PlayerValuationNotFoundException {
        PlayerValuationsDTO playerValuationsDTO = this.playerValuationService.getListPlayerValuationsByPlayer(playerId,page);
        return playerValuationsDTO;
    }
}
