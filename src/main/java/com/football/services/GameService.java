package com.football.services;

import com.football.entites.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    Game saveGame(Game game);
    Game getGame(Long Id_Game);
    void deleteGame(Long Id_Game);
    List<Game> getListGames();
}
