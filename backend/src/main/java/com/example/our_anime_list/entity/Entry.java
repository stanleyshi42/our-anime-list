package com.example.our_anime_list.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int userId;
    private int malId;
    private String title;
    private int totalEpisodes;
    private int episodesWatched = 0;
    private WatchStatus status;
    private int score = 0;
    private boolean favorite = false;

    // Most args constructor
    public Entry(int userId, int malId, String title, int totalEpisodes, int episodesWatched, WatchStatus status, int score, boolean favorite) {
        this.userId = userId;
        this.malId = malId;
        this.title = title;
        this.totalEpisodes = totalEpisodes;
        this.episodesWatched = episodesWatched;
        this.status = status;
        this.score = score;
        this.favorite = favorite;
    }
}
