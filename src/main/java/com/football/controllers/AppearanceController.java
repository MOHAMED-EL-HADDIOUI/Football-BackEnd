package com.football.controllers;

import com.football.entites.Appearance;
import com.football.services.AppearanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
