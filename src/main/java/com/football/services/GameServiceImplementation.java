package com.football.services;
import com.football.entites.Game;
import com.football.repository.GameRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GameServiceImplementation implements GameService{
    @Autowired
    @Order(1)
    GameRepository gameRepository;

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game getGame(Long Id_Game) {
        return gameRepository.getById(Id_Game);
    }

    @Override
    public void deleteGame(Long Id_Game) {
        gameRepository.deleteById(Id_Game);

    }

    @Override
    public List<Game> getListGames() {
        return gameRepository.findAll();
    }
}
