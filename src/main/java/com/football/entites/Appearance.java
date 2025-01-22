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
public class Appearance {

    @Id
    private String appearanceId;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "playerClubId", referencedColumnName = "clubId")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "playerCurrentClubId", referencedColumnName = "clubId")
    private Club currentclub;

    private Date date;
    private String playerName;
    private int yellowCards;
    private int redCards;
    private int goals;
    private int assists;
    private int minutesPlayed;

    @ManyToOne
    @JoinColumn(name = "gameId", referencedColumnName = "gameId")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "competitionId", referencedColumnName = "competitionId")
    private Competition competition;
}
