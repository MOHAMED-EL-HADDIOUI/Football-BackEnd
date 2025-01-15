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
@AllArgsConstructor
@NoArgsConstructor
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
}