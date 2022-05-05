package com.dev.backend.domain.team;

import com.dev.backend.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TeamInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private AtomicLong id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    private Boolean isLeader;
}
