package com.soccerapp.backend.repository;

import com.soccerapp.backend.entity.GameWatched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameWatchedRepository extends JpaRepository<GameWatched, Long> {

    @Query("SELECT g FROM GameWatched g ORDER BY g.id DESC LIMIT 1")
    Optional<GameWatched> findMostRecentGame();
}
