package com.example.Aenba.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter @Setter
@NoArgsConstructor
public class Team {
    @Id
    private Long id;

    private String name;
    private String city;
    private String abbreviation;
    private String coachName;

    public Team(Long id, String name, String city, String abbreviation, String coachName) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.abbreviation = abbreviation;
        this.coachName = coachName;
    }
}
