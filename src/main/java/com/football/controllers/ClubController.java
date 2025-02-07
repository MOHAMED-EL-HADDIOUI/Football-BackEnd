package com.football.controllers;

import com.football.dtos.ClubDTO;
import com.football.dtos.Club_DTO;
import com.football.dtos.ClubsDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Appearance;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.services.AppearanceService;
import com.football.services.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/clubs/competition")
    public ClubsDTO getListPlayersByCurrentClub(@RequestParam(name = "idCompetition") String idCompetition, @RequestParam(name = "page", defaultValue = "0") int page) throws ClubNotFoundException {
        ClubsDTO clubsDTO = clubService.getListClubByDomesticCompetition(idCompetition,page);
        return clubsDTO;
    }
    @GetMapping("/api/clubs/search")
    public ClubsDTO getClubsByName(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page) throws ClubNotFoundException {
        ClubsDTO clubsDTO = clubService.searchByName("%" + keyword + "%", page);
        return clubsDTO;
    }
    @PostMapping("/api/clubs/add")
    public ClubDTO addClub(@RequestBody Club_DTO club_DTO)
    {
        System.out.println("add club");
        System.out.println(club_DTO.toString());
        ClubDTO clubDTO1 = clubService.saveClub(club_DTO);
        return clubDTO1;
    }
    @PutMapping("/api/clubs/update")
    public ClubDTO updateClub(@RequestBody Club_DTO club_DTO)
    {
        System.out.println("update club");
        System.out.println(club_DTO.toString());
        ClubDTO clubDTO1 = clubService.updateClub(club_DTO);
        return clubDTO1;
    }
    @DeleteMapping("/api/clubs/delete/{clubId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long clubId) {
        System.out.println("delete club");
        clubService.deleteClub(clubId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
