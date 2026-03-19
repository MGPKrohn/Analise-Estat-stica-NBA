package com.example.Aenba.Service;

import com.example.Aenba.Client.NbaClient;
import com.example.Aenba.DTO.NbaResponseDTO;
import com.example.Aenba.Model.Team;
import com.example.Aenba.Repositories.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NbaService {

    private final NbaClient nbaClient;
    private final TeamRepository teamRepository;
    private final ObjectMapper objectMapper;

    public void importTeams() {
        try {
            // FALLBACK: Leia do arquivo local para pular o bloqueio de rede
            InputStream is = getClass().getResourceAsStream("/teams.json");
            String jsonResponse = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            NbaResponseDTO response = objectMapper.readValue(jsonResponse, NbaResponseDTO.class);
            var resultSet = response.getResultSets().get(0);
            List<List<Object>> rows = resultSet.getRowSet();

            for (List<Object> row : rows) {
                Long teamId = Long.valueOf(row.get(2).toString());
                if (teamId != 0) {
                    Team team = new Team();
                    team.setId(teamId);
                    team.setName(row.get(3).toString());
                    team.setAbbreviation(row.get(4).toString());
                    team.setCity(row.get(5).toString());
                    team.setCoachName(row.get(6).toString());

                    teamRepository.save(team);
                }
            }
            System.out.println("Dados salvos no banco com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}