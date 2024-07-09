package com.example.our_anime_list.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Nonnull
    private long userId;
    @Nonnull
    private long malId;
    private String title;
    private int totalEpisodes;
    private int episodesWatched;
    private WatchStatus status;
    private int score;
    private boolean favorite;

}
