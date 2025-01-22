package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Competition;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerDTO {
    private Long playerId;
    private String firstName;
    private String lastName;
    private String name;
    private int lastSeason;
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
    private Competition competition;

    private String currentClubName;
    private Double marketValueInEur;
    private Double highestMarketValueInEur;
}
