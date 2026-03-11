package com.example.Aenba.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient nbaWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://stats.nba.com/stats")
                .defaultHeader("Host", "stats.nba.com")
                .defaultHeader("Connection", "keep-alive")
                .defaultHeader("Accept", "application/json, text/plain, */*")
                .defaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36")
                .defaultHeader("x-nba-stats-origin", "stats")
                .defaultHeader("x-nba-stats-token", "true")
                .defaultHeader("Referer", "https://www.nba.com/")
                .defaultHeader("Origin", "https://www.nba.com")
                .build();
    }

}
