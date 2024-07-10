package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.AnimeStat;
import com.example.our_anime_list.service.AnimeStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/anime")
public class AnimeStatController {

    @Autowired
    AnimeStatService statsService;

    @Autowired
    EntryController entryController;

    @GetMapping("/{malId}")
    public ResponseEntity<?> getStats(@PathVariable long malId) {
        Integer count = statsService.countByMalId(malId);
        // If there are no entries for this MAL ID, return 404
        if (count == 0)
            return ResponseEntity.status(404).body("No data found for anime ID: " + malId);

        Double average = statsService.averageScoreByMalId(malId);

        return ResponseEntity.ok(new AnimeStat(malId, count, average));
    }
}
