package com.example.Aenba.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "games")
@Getter @Setter
@NoArgsConstructor
public class Game {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    private LocalDateTime gameData;
    private Integer homeScore;
    private Integer awayScore;

    private String season;

    @Column(name = "matchup_info")
    private String matchup;
}
