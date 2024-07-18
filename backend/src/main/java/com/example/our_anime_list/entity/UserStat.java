package com.example.our_anime_list.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

// Stores various stats for an anime
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStat {

    private String username;
    private int totalHoursWatched;
    private int totalFavorites;
    private int mostWatchedGenre;
    private int totalCurrentlyWatching;
    private int totalCompleted;
    private int totalPlannedToWatch;
    private int totalDropped;
}
