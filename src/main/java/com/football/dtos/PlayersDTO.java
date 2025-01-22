package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlayersDTO {
    List<PlayerDTO> playerDTOS;
    int totalpage ;
}
