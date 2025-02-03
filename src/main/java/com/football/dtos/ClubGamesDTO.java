package com.football.dtos;

import lombok.Data;

import java.util.List;
@Data
public class ClubGamesDTO {
    List<ClubGameDTO> clubGameDTOS;
    int totalpage ;
}
