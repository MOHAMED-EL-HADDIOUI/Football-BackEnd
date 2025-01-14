package com.football.entites;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.*;
@Entity
@Data
@Builder
@ToString
public class Competition {
    @Id
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
    public Competition() {
    }

    public Competition(String competitionId, String competitionCode, String name, String subType, String type, String countryId, String countryName, String domesticLeagueCode, String confederation, String url, boolean isMajorNationalLeague) {
        this.competitionId = competitionId;
        this.competitionCode = competitionCode;
        this.name = name;
        this.subType = subType;
        this.type = type;
        this.countryId = countryId;
        this.countryName = countryName;
        this.domesticLeagueCode = domesticLeagueCode;
        this.confederation = confederation;
        this.url = url;
        this.isMajorNationalLeague = isMajorNationalLeague;
    }
}