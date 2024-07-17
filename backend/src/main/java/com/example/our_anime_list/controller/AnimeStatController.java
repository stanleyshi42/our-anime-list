package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.AnimeStat;
import com.example.our_anime_list.entity.WatchStatus;
import com.example.our_anime_list.service.AnimeStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/stats/anime")
public class AnimeStatController {

    @Autowired
    AnimeStatService statsService;

    @Autowired
    EntryController entryController;

    @GetMapping("/{malId}")
    public AnimeStat getStats(@PathVariable long malId) {

        int count = statsService.countByMalId(malId);
        int favorites = statsService.countFavoritesByMalId(malId);
        double average = statsService.averageScoreByMalId(malId);
        HashMap<WatchStatus, Integer> watchingCount = statsService.countStatusByMalId(malId);

        return new AnimeStat(malId, count, favorites, average, watchingCount);
    }
}
