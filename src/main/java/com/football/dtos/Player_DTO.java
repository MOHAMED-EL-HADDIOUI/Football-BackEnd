package com.football.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class Player_DTO {
        private Long playerId;
        private String firstName;
        private String lastName;
        private String name;
        private int lastSeason;
        private Long currentClub;
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
        private String competition;
        private String currentClubName;
        private Double marketValueInEur;
        private Double highestMarketValueInEur;
}
