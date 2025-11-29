package com.soccerapp.backend.service;

import com.soccerapp.backend.entity.GameWatched;
import com.soccerapp.backend.repository.GameWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GameWatchedService {

    @Autowired
    private GameWatchedRepository repository;

    public List<GameWatched> getAllGames() {
        return repository.findAll();
    }

    public GameWatched addGame(GameWatched game) {
        return repository.save(game);
    }

    public long getMonthlyCount(int month, int year) {
        return repository.countGamesWatchedInMonth(month, year);
    }

    public long getTotalCount() {
        return repository.count();
    }

    public long incrementMonthlyCount() {
        LocalDate now = LocalDate.now();
        GameWatched game = new GameWatched();
        game.setGameTitle("Game watched");
        repository.save(game);
        return getMonthlyCount(now.getMonthValue(), now.getYear());
    }

    public long decrementMonthlyCount() {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        Optional<GameWatched> mostRecent = repository.findMostRecentGameInMonth(currentMonth, currentYear);
        if (mostRecent.isPresent()) {
            repository.delete(mostRecent.get());
        }

        return getMonthlyCount(currentMonth, currentYear);
    }
}
