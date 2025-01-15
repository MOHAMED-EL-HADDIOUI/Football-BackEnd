package com.football.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Game {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    @ManyToOne
    @JoinColumn(name = "competitionId", referencedColumnName = "competitionId", insertable = false, updatable = false)
    private Competition competition;
    private int season;
    private String round;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "homeClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club homeClub;
    @ManyToOne
    @JoinColumn(name = "awayClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
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