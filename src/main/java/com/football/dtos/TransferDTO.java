package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Player;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class TransferDTO {
    private Long transferId;
    private Club fromClub;
    private Club toClub;
    private Player player;
    private Date transferDate;
    private String transferSeason;
    private String fromClubName;
    private String toClubName;
    private double transferFee;
    private double marketValueInEur;
    private String playerName;
}
