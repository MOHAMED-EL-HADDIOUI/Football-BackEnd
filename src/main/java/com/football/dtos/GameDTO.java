package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Competition;
import lombok.Data;

import java.util.Date;
@Data
public class GameDTO {
        private Long gameId;
        private Competition competition;
        private int season;
        private String round;
        private Date date;
        private Club homeClub;
        private Club awayClub;

        private int homeClubGoals;
        private int awayClubGoals;
        private Double homeClubPosition;
        private Double awayClubPosition;
        private String homeClubManagerName;
        private String awayClubManagerName;
        private String stadium;
        private Double attendance;
        private String referee;
        private String url;
        private String homeClubFormation;
        private String awayClubFormation;
        private String homeClubName;
        private String awayClubName;
        private String aggregate;
        private String competitionType;

}
