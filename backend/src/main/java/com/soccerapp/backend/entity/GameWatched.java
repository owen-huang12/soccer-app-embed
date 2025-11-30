package com.soccerapp.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "games_watched")
public class GameWatched {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_title")
    private String gameTitle;

    @Column(name = "notes")
    private String notes;

    public GameWatched() {
    }

    public GameWatched(String gameTitle, String notes) {
        this.gameTitle = gameTitle;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
