package com.dev.backend.domain.project;

import com.dev.backend.domain.team.Team;
import com.dev.backend.global.domain.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Project extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private Integer projectYear;

    @Column(nullable = false)
    private Integer projectQuarter;

    @Column(nullable = true)
    private String projectPdf;

    @Column(nullable = true)
    private String projectGithub;

    @Column(nullable = true)
    private String projectImage;

    @Column(nullable = true)
    private String projectContent;

    @Column(nullable = true)
    private String projectSummary;

    @Column(columnDefinition = "json")
    private String projectTag;

    @Builder
    public Project(String projectName, Integer projectYear, Integer projectQuarter, String projectPdf, String projectGithub, String projectImage, String projectContent, String projectSummary, String projectTag) {
        this.projectName = projectName;
        this.projectYear = projectYear;
        this.projectQuarter = projectQuarter;
        this.projectPdf = projectPdf;
        this.projectGithub = projectGithub;
        this.projectImage = projectImage;
        this.projectContent = projectContent;
        this.projectSummary = projectSummary;
        this.projectTag = projectTag;
    }

}
