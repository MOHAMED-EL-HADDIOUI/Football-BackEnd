package com.football.entites;
import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class ClubGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubGameId;

    @ManyToOne
    @JoinColumn(name = "gameId", referencedColumnName = "gameId", insertable = false, updatable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club club;
    private int ownGoals;
    private Double ownPosition;
    private String ownManagerName;
    @ManyToOne
    @JoinColumn(name = "opponentId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club opponentclub;
    private int opponentGoals;
    private Double opponentPosition;
    private String opponentManagerName;
    private String hosting;
    private int isWin;
}
