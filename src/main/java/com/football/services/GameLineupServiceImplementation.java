package com.football.services;
import com.football.dtos.GameLineupDTO;
import com.football.dtos.GameLineupsDTO;
import com.football.entites.GameLineup;
import com.football.exceptions.GameLineuNotFoundException;
import com.football.mappers.GameLineupMapperImplementation;
import com.football.repository.GameLineupRepository;
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
public class GameLineupServiceImplementation implements GameLineupService {
    @Autowired
    @Order(1)
    GameLineupRepository gameLineupRepository;
    @Autowired
    GameLineupMapperImplementation dtoMapper;
    @Override
    public GameLineup saveGameLineup(GameLineup gameLineup) {
        return gameLineupRepository.save(gameLineup);
    }

    @Override
    public GameLineup getGameLineup(String Id_GameLineup) {
        return gameLineupRepository.findById(Id_GameLineup).orElse(null);
    }

    @Override
    public void deleteGameLineup(String Id_GameLineup) {
        gameLineupRepository.deleteById(Id_GameLineup);
    }

    @Override
    public List<GameLineup> getListGameLineups() {
        return gameLineupRepository.findAll();
    }

    @Override
    public GameLineupsDTO getListGameLineupsByGame(Long gameId, int page) throws GameLineuNotFoundException {
        Page<GameLineup> gameELineups ;
        gameELineups = gameLineupRepository.getListGameLineupsByGame(gameId, PageRequest.of(page,8));
        List<GameLineupDTO> gameLineupDTOS =gameELineups.getContent().stream().map(c->dtoMapper.fromGameLineup(c)).collect(Collectors.toList());
        if (gameELineups == null)
            throw new GameLineuNotFoundException("GameLineup not fount");

        GameLineupsDTO gameLineupsDTO= new GameLineupsDTO();
        gameLineupsDTO.setGameLineupDTOS(gameLineupDTOS);
        gameLineupsDTO.setTotalpage(gameELineups.getTotalPages());
        return gameLineupsDTO;
    }
}
