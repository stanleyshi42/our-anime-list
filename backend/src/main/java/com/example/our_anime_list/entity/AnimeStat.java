package com.example.our_anime_list.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

// Stores various stats for an anime
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimeStat {

    private long malId;
    private int users;
    private double averageScore;
    private Map<WatchStatus, Integer> watchStatus;

    //TODO
    //private int favorites;

}
