package com.soccerapp.backend.controller;

import com.soccerapp.backend.entity.GameWatched;
import com.soccerapp.backend.service.GameWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<Map<String, Object>> getGameCounts() {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        long monthlyCount = service.getMonthlyCount(currentMonth, currentYear);
        long totalCount = service.getTotalCount();

        Map<String, Object> response = new HashMap<>();
        response.put("monthly", monthlyCount);
        response.put("total", totalCount);
        response.put("month", currentMonth);
        response.put("year", currentYear);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/monthly")
    public ResponseEntity<Map<String, Long>> getMonthlyCount(
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {

        LocalDate now = LocalDate.now();
        int targetMonth = month != null ? month : now.getMonthValue();
        int targetYear = year != null ? year : now.getYear();

        long count = service.getMonthlyCount(targetMonth, targetYear);

        Map<String, Long> response = new HashMap<>();
        response.put("count", count);

        return ResponseEntity.ok(response);
    }
}
