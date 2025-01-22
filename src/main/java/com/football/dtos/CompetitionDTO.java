package com.football.dtos;

import lombok.Data;

@Data
public class CompetitionDTO {
    private String competitionId;
    private String competitionCode;
    private String name;
    private String subType;
    private String type;
    private String countryId;
    private String countryName;
    private String domesticLeagueCode;
    private String confederation;
    private String url;
    private boolean isMajorNationalLeague;
}
