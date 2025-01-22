package com.football.controllers;
import com.football.dtos.CompetitionsDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Player;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.services.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    @GetMapping("/api/players/search")
    public PlayersDTO getplayersByName(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page) throws PlayerNotFoundException {
        PlayersDTO playersDTO = playerService.searchByName("%" + keyword + "%", page);
        return playersDTO;
    }
}
