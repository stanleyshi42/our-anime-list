package com.example.our_anime_list.service;


import com.example.our_anime_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatService {
    @Autowired
    UserRepository userRepository;

    public String mostCommonGenre(long userId){
        return userRepository.mostCommonGenre(userId).orElse(null);
    }

    public int countByTotalFavorites(long userId){
        return userRepository.countByTotalFavorites(userId).orElse(0);
    }

    public int countByTotalWatching(long userId){
        return userRepository.countByTotalWatching(userId).orElse(0);
    }

    public int countByTotalCompleted(long userId){
        return userRepository.countByTotalCompleted(userId).orElse(0);
    }

    public int countByTotalPlanned(long userId){
        return userRepository.countByTotalPlanned(userId).orElse(0);
    }

    public int countByTotalDropped(long userId){
        return userRepository.countByTotalDropped(userId).orElse(0);
    }

}
