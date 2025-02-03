package com.football.dtos;
import com.football.entites.Club;
import com.football.entites.Game;
import lombok.Data;
@Data
public class ClubGameDTO {
        private Long clubGameId;
        private Game game;
        private Club club;
        private int ownGoals;
        private Double ownPosition;
        private String ownManagerName;
        private Club opponentclub;
        private int opponentGoals;
        private Double opponentPosition;
        private String opponentManagerName;
        private String hosting;
        private int isWin;
}
