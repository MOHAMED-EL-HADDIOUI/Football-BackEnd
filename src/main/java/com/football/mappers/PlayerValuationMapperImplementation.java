package com.football.mappers;

import com.football.dtos.GameEventDTO;
import com.football.dtos.PlayerValuationDTO;
import com.football.entites.GameEvent;
import com.football.entites.PlayerValuation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PlayerValuationMapperImplementation {
    public PlayerValuationDTO fromPlayerValuation(PlayerValuation playerValuation){
        PlayerValuationDTO playerValuationDTO = new PlayerValuationDTO();
        BeanUtils.copyProperties(playerValuation,playerValuationDTO);
        return playerValuationDTO;
    }
    public PlayerValuation fromPlayerValuationDTO(PlayerValuationDTO playerValuationDTO){
        PlayerValuation playerValuation = new PlayerValuation();
        BeanUtils.copyProperties(playerValuationDTO,playerValuation);
        return playerValuation;
    }
    public void updateplayerValuationFromDTO(PlayerValuationDTO playerValuationDTO, PlayerValuation playerValuation) {
        PlayerValuation playerValuation1 = fromPlayerValuationDTO(playerValuationDTO);
        BeanUtils.copyProperties(playerValuation1, playerValuation,"valuationId");
    }
}
