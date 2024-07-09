package com.example.our_anime_list.repository;

import com.example.our_anime_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    /*
    @Query(value = "SELECT * from user i WHERE i.username = :username",nativeQuery = true)
    ArrayList<User> findByUsername(@Param("username") String username);
    */
}