package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CompetitionsDTO {
    List<CompetitionDTO> competitionDTOS;
    int totalpage ;
}
