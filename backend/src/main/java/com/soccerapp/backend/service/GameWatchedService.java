package com.soccerapp.backend.service;

import com.soccerapp.backend.entity.GameWatched;
import com.soccerapp.backend.repository.GameWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
