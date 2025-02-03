package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AppearancesDTO {
    List<AppearanceDTO> appearanceDTOS;
    int totalpage ;
}
