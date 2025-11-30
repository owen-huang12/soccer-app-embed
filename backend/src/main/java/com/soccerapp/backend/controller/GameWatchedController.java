package com.soccerapp.backend.controller;

import com.soccerapp.backend.entity.GameWatched;
import com.soccerapp.backend.service.GameWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/games")
public class GameWatchedController {

    @Autowired
    private GameWatchedService service;

    @GetMapping
    public List<GameWatched> getAllGames() {
        return service.getAllGames();
    }

    @PostMapping
    public GameWatched addGame(@RequestBody GameWatched game) {
        return service.addGame(game);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getGameCount() {
        long count = service.getCount();

        Map<String, Long> response = new HashMap<>();
        response.put("count", count);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/increment")
    public ResponseEntity<Map<String, Long>> increment() {
        long newCount = service.increment();

        Map<String, Long> response = new HashMap<>();
        response.put("count", newCount);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/decrement")
    public ResponseEntity<Map<String, Long>> decrement() {
        long newCount = service.decrement();

        Map<String, Long> response = new HashMap<>();
        response.put("count", newCount);

        return ResponseEntity.ok(response);
    }
}
