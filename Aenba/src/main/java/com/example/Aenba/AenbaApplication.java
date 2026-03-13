package com.example.Aenba;

import com.example.Aenba.Service.NbaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AenbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AenbaApplication.class, args);
	}

    @Bean
    CommandLineRunner run(NbaService nbaService) {
        return args -> {
            nbaService.importTeams();
        };
    }
}
/*
Debugar AMANHÃ

Erro na requisição: java.util.concurrent.TimeoutException: Did not observe any item or terminal signal within 10000ms in 'flatMap' (and no fallback has been configured)
ERRO DURANTE A IMPORTAÇÃO: argument "content" is null
java.lang.IllegalArgumentException: argument "content" is null
 */