package com.example.our_anime_list.repository;

import com.example.our_anime_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByUserId(Long userId);
}
