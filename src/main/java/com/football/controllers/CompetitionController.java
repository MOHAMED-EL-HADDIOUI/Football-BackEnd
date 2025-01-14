package com.football.controllers;

import com.football.entites.Competition;
import com.football.services.CompetitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetitionController {
    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }
    @GetMapping("/api/competitions/{competition_id}")
    public Competition getAppearance(@PathVariable String competition_id){
        Competition competition = competitionService.getCompetition(competition_id);
        return competition;
    }
    @GetMapping("/api/competitions/")
    public List<Competition> getListCompetitions(){
        return  competitionService.getListCompetitions();
    }
}
