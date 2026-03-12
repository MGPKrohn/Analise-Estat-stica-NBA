package com.example.Aenba.Client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Component
public class NbaClient {

    private final WebClient webClient;

    public NbaClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String fetchCommonAllPlayers() {
        try {
            return this.webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/commonallplayers")
                            .queryParam("IsOnlyCurrentSeason", "1")
                            .queryParam("LeagueID", "00")
                            .queryParam("Season", "2025-26")
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(10)) // <--- Se não responder em 10s, ele cancela
                    .block();
        } catch (Exception e) {
            System.err.println("Erro na requisição: " + e.getMessage());
            return null;
        }
    }

}
