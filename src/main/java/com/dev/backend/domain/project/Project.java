package com.dev.backend.domain.project;

import com.dev.backend.domain.team.Team;
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
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_year", nullable = false)
    private Integer projectYear;

    @Column(name = "project_quarter", nullable = false)
    private Integer projectQuarter;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "project_pdf", nullable = true)
    private String projectPdf;

    @Column(name = "project_github", nullable = true)
    private String projectGithub;

    @Column(name = "project_image", nullable = true)
    private String projectImage;

    @Column(name = "project_content", nullable = true)
    private String projectContent;

    @Column(name = "project_summary", nullable = true)
    private String projectSummary;

    @Column(name = "project_tag", columnDefinition = "json")
    private String projectTag;

    @Builder
    public Project(String projectName, Integer projectYear, Integer projectQuarter, LocalDateTime createDate, LocalDateTime updateDate, String projectPdf, String projectGithub, String projectImage, String projectContent, String projectSummary, String projectTag) {
        this.projectName = projectName;
        this.projectYear = projectYear;
        this.projectQuarter = projectQuarter;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.projectPdf = projectPdf;
        this.projectGithub = projectGithub;
        this.projectImage = projectImage;
        this.projectContent = projectContent;
        this.projectSummary = projectSummary;
        this.projectTag = projectTag;
    }

}
