package com.football.dtos;

import lombok.Data;

import java.util.List;
@Data
public class GameLineupsDTO {
    List<GameLineupDTO> gameLineupDTOS;
    int totalpage ;
}
