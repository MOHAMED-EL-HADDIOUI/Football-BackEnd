package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ClubsDTO {
    List<ClubDTO> clubsDTOS;
    int totalpage ;
}
