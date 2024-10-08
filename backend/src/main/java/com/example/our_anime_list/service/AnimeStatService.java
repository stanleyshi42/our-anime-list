package com.example.our_anime_list.service;

import com.example.our_anime_list.entity.WatchStatus;
import com.example.our_anime_list.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AnimeStatService {

    @Autowired
    EntryRepository entryRepository;

    public int countByMalId(long malId) {
        return entryRepository.countByMalId(malId).orElse(0);
    }

    public int countFavoritesByMalId(long malId) {
        return entryRepository.countFavoritesByMalId(malId).orElse(0);
    }

    public double averageScoreByMalId(long malId) {
        return entryRepository.averageScoreByMalId(malId).orElse(0.0);
    }

    // Returns a HashMap with count for each watch status
    public HashMap<WatchStatus, Integer> countStatusByMalId(long malId) {
        int[][] result = entryRepository.countStatusByMalId(malId);
        HashMap<WatchStatus, Integer> statuses = new HashMap<WatchStatus, Integer>();

        // Instantiate keys for each status with a count of 0
        for (WatchStatus s : WatchStatus.values()) {
            statuses.put(s, 0);
        }

        // Update keys with the actual count
        for (int i = 0; i < result.length; i++) {
            WatchStatus status = WatchStatus.values()[result[i][0]];   // Get the corresponding enum
            int statusCount = result[i][1];
            statuses.put(status, statusCount);
        }

        return statuses;
    }

}