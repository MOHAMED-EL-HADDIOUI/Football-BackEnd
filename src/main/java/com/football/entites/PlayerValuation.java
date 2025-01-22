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
public class PlayerValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valuationId;

    @ManyToOne
    @JoinColumn(name = "currentClubId", referencedColumnName = "clubId")
    private Club currentClub;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    private Date date;

    private Double marketValueInEur;

    @ManyToOne
    @JoinColumn(name = "playerClubDomesticCompetitionId", referencedColumnName = "competitionId")
    private Competition competition;
}
