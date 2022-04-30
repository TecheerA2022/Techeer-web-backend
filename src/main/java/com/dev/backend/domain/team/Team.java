package com.dev.backend.domain.team;

import com.dev.backend.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private Integer teamYear;

    @Column(nullable = false)
    private Integer teamSemester;

    @ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    @Builder
    public Team(String teamName, Integer teamYear, Integer teamSemester) {
        this.teamName = teamName;
        this.teamYear = teamYear;
        this.teamSemester = teamSemester;
    }
}
