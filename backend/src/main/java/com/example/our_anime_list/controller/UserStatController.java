package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.UserStat;
import com.example.our_anime_list.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/user")
public class UserStatController {

    @Autowired
    UserStatService statService;

    @GetMapping("/{userId}")
    public UserStat getStats(@PathVariable long userId){
        int favorites = statService.countByTotalFavorites(userId);
        int totalCompleted = statService.countByTotalCompleted(userId);
        int totalDropped = statService.countByTotalDropped(userId);
        int totalPlanned = statService.countByTotalPlanned(userId);
        int totalWatching = statService.countByTotalWatching(userId);
        String commonGenre = statService.mostCommonGenre(userId);
        // still in progress
        return new UserStat(favorites,commonGenre, totalCompleted, totalDropped, totalPlanned, totalWatching);
    }

}
