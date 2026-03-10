package com.example.Aenba.Repositories;

import com.example.Aenba.Model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameRepository {
    @Query("SELECT g FROM Games WHERE (g.homeTeam.id = :teamA and g.awayTeam.id = :teamB ) " +
            "OR (g.homeTeam.id = :teamB AND g.awayTeam.id = :teamA) ORDER BY g.gameDate DESC")
    List<Game> findHeadToHead(Long teamA, Long teamB);


    List<Game> findByHomeTeamIdOrAwayTeamIdAndGameDataAfter(Long homeId, Long awayId, LocalDateTime date);

}
