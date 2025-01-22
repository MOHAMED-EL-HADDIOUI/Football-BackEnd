package com.football.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
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
    @JoinColumn(name = "gameId", referencedColumnName = "gameId")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "clubId")
    private Club club;
    private int ownGoals;
    private Double ownPosition;
    private String ownManagerName;
    @ManyToOne
    @JoinColumn(name = "opponentId", referencedColumnName = "clubId")
    private Club opponentclub;
    private int opponentGoals;
    private Double opponentPosition;
    private String opponentManagerName;
    private String hosting;
    private int isWin;
}
