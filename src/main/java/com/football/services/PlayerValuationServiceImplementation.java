package com.football.services;
import com.football.dtos.PlayerDTO;
import com.football.dtos.PlayerValuationDTO;
import com.football.dtos.PlayerValuationsDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.Player;
import com.football.entites.PlayerValuation;
import com.football.exceptions.PlayerNotFoundException;
import com.football.exceptions.PlayerValuationNotFoundException;
import com.football.mappers.PlayerValuationMapperImplementation;
import com.football.repository.PlayerValuationRepository;
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
public class PlayerValuationServiceImplementation implements PlayerValuationService{
    @Autowired
    @Order(1)
    PlayerValuationRepository playerValuationRepository;
    @Autowired
    PlayerValuationMapperImplementation dtoMapper;

    @Override
    public PlayerValuation savePlayerValuation(PlayerValuation playerValuation) {
        return playerValuationRepository.save(playerValuation);
    }

    @Override
    public PlayerValuation getPlayerValuation(Long Id_PlayerValuation) {
        return playerValuationRepository.getById(Id_PlayerValuation);
    }

    @Override
    public void deletePlayerValuation(Long Id_PlayerValuation) {
        playerValuationRepository.deleteById(Id_PlayerValuation);
    }

    @Override
    public List<PlayerValuation> getListPlayerValuations() {
        return playerValuationRepository.findAll();
    }

    @Override
    public PlayerValuationsDTO getListPlayerValuationsByPlayer(Long playerId, int page) throws PlayerValuationNotFoundException {
        Page<PlayerValuation> playerValuations ;
        playerValuations = playerValuationRepository.getListPlayerValuationsByPlayer(playerId, PageRequest.of(page,8));
        List<PlayerValuationDTO> playerValuationDTOS=playerValuations.getContent().stream().map(c->dtoMapper.fromPlayerValuation(c)).collect(Collectors.toList());
        if (playerValuations == null)
            throw new PlayerValuationNotFoundException("PlayerValuation not fount");
        PlayerValuationsDTO playerValuationsDTO= new PlayerValuationsDTO();
        playerValuationsDTO.setPlayerValuationDTOS(playerValuationDTOS);
        playerValuationsDTO.setTotalpage(playerValuations.getTotalPages());
        return playerValuationsDTO;
    }
}
