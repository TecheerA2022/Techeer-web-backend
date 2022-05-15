package com.dev.backend.domain.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String teamName;

    @Column(nullable = false)
    private Integer teamYear;

    @Column(nullable = false)
    private Integer teamSemester;



    @Builder
    public Team(String teamName, Integer teamYear, Integer teamSemester) {
        this.teamName = teamName;
        this.teamYear = teamYear;
        this.teamSemester = teamSemester;
    }
}
