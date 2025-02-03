package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.entites.Game;
import com.football.entites.Player;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class AppearanceDTO {
    private String appearanceId;
    private Player player;
    private Club club;
    private Club currentclub;
    private Date date;
    private String playerName;
    private int yellowCards;
    private int redCards;
    private int goals;
    private int assists;
    private int minutesPlayed;
    private Game game;
    private Competition competition;
}
