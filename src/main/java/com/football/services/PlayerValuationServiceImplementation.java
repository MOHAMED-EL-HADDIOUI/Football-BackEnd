package com.football.services;
import com.football.entites.PlayerValuation;
import com.football.repository.PlayerValuationRepository;
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
public class PlayerValuationServiceImplementation implements PlayerValuationService{
    @Autowired
    @Order(1)
    PlayerValuationRepository playerValuationRepository;

    @Override
    public PlayerValuation saveClub(PlayerValuation playerValuation) {
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
}
