package com.football.controllers;

import com.football.entites.Appearance;
import com.football.entites.Club;
import com.football.services.AppearanceService;
import com.football.services.ClubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping("/api/clubs/{club_id}")
    public Club getClub(@PathVariable Long club_id){
        Club club = clubService.getClub(club_id);
        return club;
    }
    @GetMapping("/api/clubs/")
    public List<Club> getListClubs(){
        return  clubService.getListClubs();
    }
}
