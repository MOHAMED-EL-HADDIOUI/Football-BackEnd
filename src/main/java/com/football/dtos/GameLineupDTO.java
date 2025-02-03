package com.football.dtos;

import com.football.entites.Club;
import com.football.entites.Game;
import com.football.entites.Player;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class GameLineupDTO {
    private String gameLineupsId;
    private Date date;
    private Game game;
    private Club club;
    private Player player;
    private String playerName;
    private String type;
    private String position;
    private String number;
    private int teamCaptain;
}
