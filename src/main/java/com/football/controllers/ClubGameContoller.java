package com.football.controllers;

import com.football.dtos.AppearancesDTO;
import com.football.dtos.ClubGamesDTO;
import com.football.entites.Appearance;
import com.football.entites.ClubGame;
import com.football.exceptions.ClubGameNotFoundException;
import com.football.exceptions.TransferNotFoundException;
import com.football.services.ClubGameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClubGameContoller {
    private ClubGameService clubGameService;

    public ClubGameContoller(ClubGameService clubGameService) {
        this.clubGameService = clubGameService;
    }
    @GetMapping("/api/clubgames/game")
    public ClubGamesDTO getListClubGamesByGame(@RequestParam(name = "gameId", defaultValue = "") Long gameId, @RequestParam(name = "page", defaultValue = "0") int page) throws ClubGameNotFoundException {
        ClubGamesDTO clubGamesDTO = this.clubGameService.getListClubGamesByGame(gameId,page);
        return clubGamesDTO;
    }

}
