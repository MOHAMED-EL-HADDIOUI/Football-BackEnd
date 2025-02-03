package com.football.services;

import com.football.dtos.PlayerValuationsDTO;
import com.football.dtos.PlayersDTO;
import com.football.entites.PlayerValuation;
import com.football.exceptions.PlayerNotFoundException;
import com.football.exceptions.PlayerValuationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerValuationService {
    PlayerValuation savePlayerValuation( PlayerValuation playerValuation);
    PlayerValuation getPlayerValuation(Long Id_PlayerValuation);
    void deletePlayerValuation(Long Id_PlayerValuation);
    List< PlayerValuation> getListPlayerValuations();
    PlayerValuationsDTO getListPlayerValuationsByPlayer(Long playerId, int page) throws PlayerValuationNotFoundException;

}
