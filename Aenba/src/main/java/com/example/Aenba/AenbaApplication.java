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

adicionar finals nas classes da NBA SERVICE
aplicar STATIC na DTO
salvar o team.json na pasta resources

 */