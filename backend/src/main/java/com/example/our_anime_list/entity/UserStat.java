package com.example.our_anime_list.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Stores various stats for an anime
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStat {

    private String username;
    private int totalHoursWatched;
    private int totalFavorites;
    private String mostWatchedGenre;
    private int totalCurrentlyWatching;
    private int totalCompleted;
    private int totalPlannedToWatch;
    private int totalDropped;


    public UserStat(int favorites, String mostWatchedGenre, int totalCompleted , int totalDropped
            , int totalFavorites, int totalCurrentlyWatching) {
    }
}
