package com.football.dtos;

import com.football.entites.Competition;
import lombok.Data;

@Data
public class Club_DTO {
    private Long clubId;
    private String clubCode;
    private String name;
    private String domesticCompetition;
    private Double totalMarketValue;
    private int squadSize;
    private double averageAge;
    private int foreignersNumber;
    private double foreignersPercentage;
    private int nationalTeamPlayers;
    private String stadiumName;
    private int stadiumSeats;
    private String netTransferRecord;
    private String coachName;
    private int lastSeason;
    private String filename;
    private String url;
}
