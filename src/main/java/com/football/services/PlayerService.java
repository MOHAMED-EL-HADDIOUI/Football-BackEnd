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
    PlayersDTO searchByCompetition(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByName(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByCurrentClub(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByPosition(String name, int page) throws PlayerNotFoundException;

}
