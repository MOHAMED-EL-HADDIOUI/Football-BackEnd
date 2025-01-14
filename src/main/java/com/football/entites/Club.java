package com.football.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Builder
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String clubCode;
    private String name;
    @ManyToOne
    @JoinColumn(name = "domesticCompetitionId", referencedColumnName = "competitionId", insertable = false, updatable = false)
    private Competition domesticCompetition;

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
    public Club(Long clubId,String clubCode, String name, Competition domesticCompetition,
                Double totalMarketValue, int squadSize, double averageAge, int foreignersNumber,
                double foreignersPercentage, int nationalTeamPlayers, String stadiumName,
                int stadiumSeats, String netTransferRecord, String coachName, int lastSeason,
                String filename, String url) {
        this.clubId = clubId;
        this.clubCode = clubCode;
        this.name = name;
        this.domesticCompetition = domesticCompetition;
        this.totalMarketValue = totalMarketValue;
        this.squadSize = squadSize;
        this.averageAge = averageAge;
        this.foreignersNumber = foreignersNumber;
        this.foreignersPercentage = foreignersPercentage;
        this.nationalTeamPlayers = nationalTeamPlayers;
        this.stadiumName = stadiumName;
        this.stadiumSeats = stadiumSeats;
        this.netTransferRecord = netTransferRecord;
        this.coachName = coachName;
        this.lastSeason = lastSeason;
        this.filename = filename;
        this.url = url;
    }
}
