package com.football.entites;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class GameEvent {
    @Id
    private String gameEventId;

    private Date date;
    private int minute;
    private String type;

    @ManyToOne
    @JoinColumn(name = "gameId", referencedColumnName = "gameId", insertable = false, updatable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club club;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    private Player player;

    private String description;
    private String playerInId;
    private String playerAssistId;
}
