package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlayerValuationsDTO {
    List<PlayerValuationDTO> playerValuationDTOS;
    int totalpage ;
}
