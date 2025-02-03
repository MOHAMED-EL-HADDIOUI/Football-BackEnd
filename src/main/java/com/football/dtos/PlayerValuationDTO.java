package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.entites.Player;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerValuationDTO {
    private Long valuationId;
    private Club currentClub;
    private Player player;
    private Date date;
    private Double marketValueInEur;
    private Competition competition;
}
