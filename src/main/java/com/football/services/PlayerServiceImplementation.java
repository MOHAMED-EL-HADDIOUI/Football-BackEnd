package com.football.services;
import com.football.dtos.ClubDTO;
import com.football.dtos.ClubsDTO;
import com.football.dtos.PlayerDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Club;
import com.football.entites.Player;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.mappers.PlayerMapperImplementation;
import com.football.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    PlayerMapperImplementation dtoMapper;

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayer(Long Id_Player) {
        return playerRepository.findById(Id_Player).orElse(null);
    }

    @Override
    public void deletePlayer(Long Id_Player) {
        playerRepository.deleteById(Id_Player);

    }

    @Override
    public List<Player> getListPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public PlayersDTO searchByName(String name, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.searchByName(name, PageRequest.of(page,20));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");

        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }
}
