package com.soccerapp.backend.repository;

import com.soccerapp.backend.entity.GameWatched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface GameWatchedRepository extends JpaRepository<GameWatched, Long> {

    @Query("SELECT COUNT(g) FROM GameWatched g WHERE g.watchedAt >= :startDate AND g.watchedAt < :endDate")
    long countGamesWatchedBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT COUNT(g) FROM GameWatched g WHERE FUNCTION('MONTH', g.watchedAt) = :month AND FUNCTION('YEAR', g.watchedAt) = :year")
    long countGamesWatchedInMonth(int month, int year);
}
