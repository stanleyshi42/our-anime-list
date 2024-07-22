package com.example.our_anime_list.repository;

import com.example.our_anime_list.entity.User;
import com.example.our_anime_list.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

    @Query(value = "SELECT COUNT(*) FROM Entry e where e.userId = :userId AND e.status = 'WATCHING'", nativeQuery = true)
    Optional<Integer> countByTotalWatching(long userId);

    @Query(value = "SELECT COUNT(*) from Entry e WHERE e.status = 'COMPLETED' AND e.userId = :userId", nativeQuery = true)
    Optional<Integer> countByTotalCompleted(@Param("userId") long userId);

    @Query(value = "SELECT COUNT(*) FROM Entry e where e.userId = :userId AND e.status = 'WANT_TO_WATCH'", nativeQuery = true)
    Optional<Integer> countByTotalPlanned(@Param("userId") long userId);

    @Query(value = "SELECT COUNT(*) FROM Entry e where e.userId = :userId AND e.status = 'DROPPED'", nativeQuery = true)
    Optional<Integer> countByTotalDropped( @Param("userId") long userId);

}
