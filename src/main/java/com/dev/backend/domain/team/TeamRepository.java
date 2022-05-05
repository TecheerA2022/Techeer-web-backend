package com.dev.backend.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface TeamRepository extends JpaRepository<Team, AtomicLong> {
    Team findByTeamName(String teamName);
}
