package com.football.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TransfersDTO {
    List<TransferDTO> transferDTOS;
    int totalpage ;
}
