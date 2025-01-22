package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GamesDTO {
    List<GameDTO> gameDTOS;
    int totalpage ;
}
