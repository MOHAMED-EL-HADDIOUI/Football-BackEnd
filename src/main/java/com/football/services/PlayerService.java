package com.football.services;

import com.football.entites.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    Player savePlayer(Player player);
    Player getPlayer(Long Id_Player);
    void deletePlayer(Long Id_Player);
    List<Player> getListPlayers();
}
