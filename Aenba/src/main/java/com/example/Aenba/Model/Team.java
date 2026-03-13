package com.example.Aenba.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    private Long id;

    private String name;
    private String city;
    private String abbreviation;
    private String coachName;

    public Team(Long teamId, String teamName, String abbreviation) {
        this.id = teamId;
        this.name = teamName;
        this.abbreviation = abbreviation;
    }
}
