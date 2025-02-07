package com.football.services;

import com.football.dtos.GamesDTO;
import com.football.dtos.PlayerDTO;
import com.football.dtos.Player_DTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Player;
import com.football.exceptions.GameNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    PlayerDTO savePlayer(Player_DTO player_dto);
    PlayerDTO updatePlayer(Player_DTO player_dto);

    Player getPlayer(Long Id_Player);
    void deletePlayer(Long Id_Player);
    List<Player> getListPlayers();
    PlayersDTO searchByCompetition(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByName(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByCurrentClub(String name, int page) throws PlayerNotFoundException;
    PlayersDTO searchByPosition(String name, int page) throws PlayerNotFoundException;
    PlayersDTO getListPlayersByCurrentClub(Long Id_club, int page) throws PlayerNotFoundException;


}
