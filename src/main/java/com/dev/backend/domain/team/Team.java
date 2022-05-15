package com.dev.backend.domain.team;

import com.dev.backend.global.domain.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams", uniqueConstraints = {@UniqueConstraint(columnNames = "team_name")})
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "team_name")
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
