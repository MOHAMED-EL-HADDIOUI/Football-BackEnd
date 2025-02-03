package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GameEventsDTO {
    List<GameEventDTO> gameEventDTOS;
    int totalpage ;
}
