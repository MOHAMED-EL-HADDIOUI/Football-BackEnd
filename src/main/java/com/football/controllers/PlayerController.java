package com.football.controllers;
import com.football.dtos.*;
import com.football.entites.Player;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping("/api/players/{player_id}")
    public Player get(@PathVariable Long player_id){
        Player player = playerService.getPlayer(player_id);
        return player;
    }
    @GetMapping("/api/players/")
    public List<Player> getListPlayers(){
        return  playerService.getListPlayers();
    }
    @GetMapping("/api/players/club")
    public PlayersDTO getListPlayersByCurrentClub(@RequestParam(name = "idclub") Long idclub, @RequestParam(name = "page", defaultValue = "0") int page) throws PlayerNotFoundException {
        PlayersDTO playersDTO = playerService.getListPlayersByCurrentClub(idclub,page);
        return playersDTO;
    }
        @GetMapping("/api/players/search")
    public PlayersDTO getplayers(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "criteria", defaultValue = "name") String criteria) throws PlayerNotFoundException {
        PlayersDTO playersDTO = new PlayersDTO();
        if(Objects.equals(criteria, "name"))
        {
            playersDTO =  playerService.searchByName("%" + keyword + "%", page);
        }
        else if(Objects.equals(criteria, "position"))
        {
            playersDTO =  playerService.searchByPosition("%" + keyword + "%", page);
        }
        else if(Objects.equals(criteria, "currentclub"))
        {
            playersDTO =  playerService.searchByCurrentClub("%" + keyword + "%", page);
        }
        else {
            playersDTO =  playerService.searchByCompetition("%" + keyword + "%", page);
        }
        return playersDTO;
    }
    @PostMapping("/api/players/add")
    public PlayerDTO addPlayer(@RequestBody Player_DTO player_dto)
    {
        System.out.println("add player");
        System.out.println(player_dto.toString());
        PlayerDTO playerDTO = playerService.savePlayer(player_dto);
        return playerDTO;
    }
    @PutMapping("/api/players/update")
    public PlayerDTO updatePlayer(@RequestBody Player_DTO player_dto)
    {
        System.out.println("update player");
        System.out.println(player_dto.toString());
        PlayerDTO playerDTO = playerService.updatePlayer(player_dto);
        return playerDTO;
    }
    @DeleteMapping("/api/players/delete/{playerId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long playerId) {
        System.out.println("delete player");
        playerService.deletePlayer(playerId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
