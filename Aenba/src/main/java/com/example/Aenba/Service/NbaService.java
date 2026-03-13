package com.example.Aenba.Service;

import com.example.Aenba.Client.NbaClient;
import com.example.Aenba.DTO.NbaResponseDTO;
import com.example.Aenba.Model.Team;
import com.example.Aenba.Repositories.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Garanta que o plugin do Lombok esteja ativo no IntelliJ
public class NbaService {

    private final NbaClient nbaClient;
    private final TeamRepository teamRepository;
    private final ObjectMapper objectMapper;

    public void importTeams() {
        try {
            String jsonResponse = nbaClient.fetchCommonAllPlayers();
            if (jsonResponse == null) return;

            NbaResponseDTO response = objectMapper.readValue(jsonResponse, NbaResponseDTO.class);
            var resultSet = response.getResultSets().get(0);
            List<List<Object>> rows = resultSet.getRowSet();

            for (List<Object> row : rows) {
                Long teamId = Long.valueOf(row.get(2).toString());
                String teamName = row.get(3).toString();
                String abbreviation = row.get(4).toString();

                if (teamId != 0) {
                    Team team = new Team();
                    team.setId(teamId);
                    team.setName(teamName);
                    team.setAbbreviation(abbreviation);

                    teamRepository.save(team);
                }
            }
            System.out.println("Times importados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}