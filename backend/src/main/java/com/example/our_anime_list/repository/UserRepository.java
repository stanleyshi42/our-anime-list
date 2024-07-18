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

    //@Query("SELECT")
    //Optional<Integer> totalTimeWatched();

    @Query("SELECT genres FROM Entry e GROUP BY genres ORDER BY COUNT(*) DESC LIMIT 1")
    Optional<String> mostCommonGenre(long userId);


    @Query("SELECT COUNT(*) FROM Entry e where e.userId = ?1 and e.favorite = TRUE")
    Optional<Integer> countByTotalFavorites(long userId);

    @Query("SELECT COUNT(*) FROM Entry e where e.userId = ?1 AND e.status = 'WATCHING'")
    Optional<Integer> countByTotalWatching(long userId);

    @Query("SELECT COUNT(*) FROM Entry e where e.userId = ?1 AND e.status = 'COMPLETED'")
    Optional<Integer> countByTotalCompleted(long userId);

    @Query("SELECT COUNT(*) FROM Entry e where e.userId = ?1 AND e.status = 'WANT_TO_WATCH'")
    Optional<Integer> countByTotalPlanned(long userId);

    @Query("SELECT COUNT(*) FROM Entry e where e.userId = ?1 AND e.status = 'DROPPED'")
    Optional<Integer> countByTotalDropped(long userId);


    /*
    @Query(value = "SELECT * from user i WHERE i.username = :username",nativeQuery = true)
    ArrayList<User> findByUsername(@Param("username") String username);
    */
}