package com.football.services;

import com.football.entites.PlayerValuation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerValuationService {
    PlayerValuation saveClub( PlayerValuation playerValuation);
    PlayerValuation getPlayerValuation(Long Id_PlayerValuation);
    void deletePlayerValuation(Long Id_PlayerValuation);
    List< PlayerValuation> getListPlayerValuations();
}
