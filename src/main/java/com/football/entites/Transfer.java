package com.football.entites;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;

    @ManyToOne
    @JoinColumn(name = "fromClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club fromClub;

    @ManyToOne
    @JoinColumn(name = "toClubId", referencedColumnName = "clubId", insertable = false, updatable = false)
    private Club toClub;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    private Player player;

    private Date transferDate;
    private String transferSeason;
    private String fromClubName;
    private String toClubName;
    private double transferFee;
    private double marketValueInEur;
    private String playerName;
}
