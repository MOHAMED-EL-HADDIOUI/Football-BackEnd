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
public class GameEventDTO {
    private String gameEventId;
    private Date date;
    private int minute;
    private String type;
    private Game game;
    private Club club;
    private Player player;
    private String description;
    private Player playerIn;
    private Player playerAssist;
}
