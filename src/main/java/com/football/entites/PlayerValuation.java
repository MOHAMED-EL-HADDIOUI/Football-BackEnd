package com.football.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    @JoinColumn(name = "currentClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club currentClub;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    private Player player;

    private Date date;

    private Double marketValueInEur;

    @ManyToOne
    @JoinColumn(name = "playerClubDomesticCompetitionId", referencedColumnName = "competitionId", insertable = false, updatable = false)
    private Competition competition;
}
