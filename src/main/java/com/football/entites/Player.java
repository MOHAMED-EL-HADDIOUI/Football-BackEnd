package com.football.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Player {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String firstName;
    private String lastName;
    private String name;
    private int lastSeason;
    @ManyToOne
    @JoinColumn(name = "currentClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club currentClub;

    private String playerCode;
    private String countryOfBirth;
    private String cityOfBirth;
    private String countryOfCitizenship;
    private Date dateOfBirth;
    private String subPosition;
    private String position;
    private String foot;
    private Double heightInCm;
    private Date contractExpirationDate;
    private String agentName;
    private String imageUrl;
    private String url;
    @ManyToOne
    @JoinColumn(name = "currentClubDomesticCompetitionId", referencedColumnName = "competitionId", insertable = false, updatable = false)
    private Competition competition;

    private String currentClubName;
    private Double marketValueInEur;
    private Double highestMarketValueInEur;
}
