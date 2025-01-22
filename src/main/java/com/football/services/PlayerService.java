package com.football.services;

import com.football.dtos.GamesDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Player;
import com.football.exceptions.GameNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    Player savePlayer(Player player);
    Player getPlayer(Long Id_Player);
    void deletePlayer(Long Id_Player);
    List<Player> getListPlayers();
    PlayersDTO searchByName(String name, int page) throws PlayerNotFoundException;

}
