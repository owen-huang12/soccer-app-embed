package com.soccerapp.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "games_watched")
public class GameWatched {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "watched_at")
    private LocalDateTime watchedAt;

    @Column(name = "game_title")
    private String gameTitle;

    @Column(name = "notes")
    private String notes;

    public GameWatched() {
        this.watchedAt = LocalDateTime.now();
    }

    public GameWatched(String gameTitle, String notes) {
        this.gameTitle = gameTitle;
        this.notes = notes;
        this.watchedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(LocalDateTime watchedAt) {
        this.watchedAt = watchedAt;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
