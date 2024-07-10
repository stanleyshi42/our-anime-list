package com.example.our_anime_list.service;

import com.example.our_anime_list.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeStatService {

    @Autowired
    EntryRepository entryRepository;

    public Integer countByMalId(long malId) {
        return entryRepository.countByMalId(malId).orElse(null);
    }

    public Double averageScoreByMalId(long malId) {
        return entryRepository.averageScoreByMalId(malId).orElse(null);
    }

}