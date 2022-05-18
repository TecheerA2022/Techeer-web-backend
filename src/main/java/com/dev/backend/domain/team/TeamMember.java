package com.dev.backend.domain.team;

import com.dev.backend.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    private Boolean isLeader;

    @Builder
    public TeamMember(User user, Team team, Boolean isLeader) {
        this.user = user;
        this.team = team;
        this.isLeader = isLeader;
    }
}
