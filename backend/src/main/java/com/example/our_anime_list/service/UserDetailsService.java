package com.example.our_anime_list.service;

import com.example.our_anime_list.entity.Entry;
import com.example.our_anime_list.repository.EntryRepository;
import com.example.our_anime_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    UserRepository repo;



}
