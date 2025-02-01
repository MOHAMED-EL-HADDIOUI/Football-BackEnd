package com.football.controllers;

import com.football.dtos.ClubsDTO;
import com.football.dtos.CompetitionsDTO;
import com.football.entites.Competition;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.services.CompetitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetitionController {
    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }
    @GetMapping("/api/competitions/{competition_id}")
    public Competition getCompetitionsByCompetition(@PathVariable String competition_id){
        Competition competition = competitionService.getCompetition(competition_id);
        return competition;
    }
    @GetMapping("/api/competitions/")
    public List<Competition> getListCompetitions(){
        return  competitionService.getListCompetitions();
    }
    @GetMapping("/api/competitions/search")
    public CompetitionsDTO getCompetitionsByName(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page) throws CompetitionNotFoundException {
        CompetitionsDTO competitionsDTO = competitionService.searchByName("%" + keyword + "%", page);
        return competitionsDTO;
    }
}
