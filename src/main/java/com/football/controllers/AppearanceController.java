package com.football.controllers;

import com.football.dtos.AppearancesDTO;
import com.football.dtos.ClubsDTO;
import com.football.entites.Appearance;
import com.football.exceptions.AppearanceNotFoundException;
import com.football.exceptions.ClubNotFoundException;
import com.football.services.AppearanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class AppearanceController {
    private AppearanceService appearanceService;

    public AppearanceController(AppearanceService appearanceService) {
        this.appearanceService = appearanceService;
    }
    @GetMapping("/api/appearances/{appearance_id}")
    public Appearance getAppearance(@PathVariable String appearance_id){
        Appearance appearance = appearanceService.getAppearance(appearance_id);
        return appearance;
    }
    @GetMapping("/api/appearances/")
    public List<Appearance> getAppearances(){
        return  appearanceService.getListAppearances();
    }
    @GetMapping("/api/appearances/player")
    public AppearancesDTO getListPlayersByCurrentClub(@RequestParam(name = "playerId") Long playerId, @RequestParam(name = "page", defaultValue = "0") int page) throws AppearanceNotFoundException {
        AppearancesDTO appearancesDTO = appearanceService.getListAppearancesByPlayer(playerId,page);
        return appearancesDTO;
    }
}
