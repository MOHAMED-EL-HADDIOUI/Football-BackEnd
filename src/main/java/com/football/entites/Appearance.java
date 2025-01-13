package com.football.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Appearance {

    @Id
    private String appearanceId;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "playerClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club club;

    @ManyToOne
    @JoinColumn(name = "playerCurrentClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club currentclub;

    private Date date;
    private String playerName;
    private int yellowCards;
    private int redCards;
    private int goals;
    private int assists;
    private int minutesPlayed;

    @ManyToOne
    @JoinColumn(name = "gameId", referencedColumnName = "gameId", insertable = false, updatable = false)
    private Game game;
    @ManyToOne
    @JoinColumn(name = "competitionId", referencedColumnName = "competitionId", insertable = false, updatable = false)
    private Competition competition;
}
