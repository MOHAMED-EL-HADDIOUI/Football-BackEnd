package com.football.entites;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
public class Club {
    @Id
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
}
