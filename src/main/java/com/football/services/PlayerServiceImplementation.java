package com.football.services;
import com.football.entites.Player;
import com.football.repository.PlayerRepository;
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
public class PlayerServiceImplementation implements PlayerService{
    @Autowired
    @Order(1)
    PlayerRepository playerRepository;

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayer(Long Id_Player) {
        return playerRepository.getById(Id_Player);
    }

    @Override
    public void deletePlayer(Long Id_Player) {
        playerRepository.deleteById(Id_Player);

    }

    @Override
    public List<Player> getListPlayers() {
        return playerRepository.findAll();
    }
}
