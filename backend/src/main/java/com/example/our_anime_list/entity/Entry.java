package com.example.our_anime_list.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Nonnull
    private long userId;
    @Nonnull
    private long malId;     // MyAnimeList ID
    private String title;
    private int totalEpisodes;
    private int episodesWatched;
    private String[] genres;
    private WatchStatus status;
    private int score;
    private boolean favorite;
    private int durationMinutes;
    private String imageUrl;
}
