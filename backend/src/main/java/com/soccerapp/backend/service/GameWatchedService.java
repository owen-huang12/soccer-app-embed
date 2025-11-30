package com.soccerapp.backend.service;

import com.soccerapp.backend.entity.GameWatched;
import com.soccerapp.backend.repository.GameWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public long getCount() {
        return repository.count();
    }

    public long increment() {
        GameWatched game = new GameWatched();
        game.setGameTitle("Game watched");
        repository.save(game);
        return repository.count();
    }

    public long decrement() {
        Optional<GameWatched> mostRecent = repository.findMostRecentGame();
        if (mostRecent.isPresent()) {
            repository.delete(mostRecent.get());
        }
        return repository.count();
    }
}
