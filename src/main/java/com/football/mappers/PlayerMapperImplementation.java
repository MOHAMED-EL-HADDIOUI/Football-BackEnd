package com.football.mappers;

import com.football.dtos.GameDTO;
import com.football.dtos.PlayerDTO;
import com.football.entites.Game;
import com.football.entites.Player;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapperImplementation {
    public PlayerDTO fromPlayer(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        BeanUtils.copyProperties(player,playerDTO);
        return playerDTO;
    }
    public Player fromPlayerDTO(PlayerDTO playerDTO){
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO,player);
        return player;
    }
    public void updatePlayerFromDTO(PlayerDTO playerDTO, Player player) {
        Player player1 = fromPlayerDTO(playerDTO);
        BeanUtils.copyProperties(player1, player,"playerId");
    }
}
