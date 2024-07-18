package com.example.our_anime_list.repository;

import com.example.our_anime_list.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByUserId(long userId);
    List<Entry> findByMalId(long malId);
    Optional<Entry> findByUserIdAndMalId(long userId, long malId);
    List<Entry> findByUserIdAndFavoriteTrue(long userId);

    // Site wide stat aggregation for a specific anime

    @Query("SELECT COUNT(*) FROM Entry e WHERE e.malId = ?1")
    Optional<Integer> countByMalId(long malId);

    @Query("SELECT COUNT(*) FROM Entry e WHERE e.malId = ?1 AND e.favorite = TRUE")
    Optional<Integer> countFavoritesByMalId(long malId);

    // Get average score, ignoring a score of 0
    @Query("SELECT AVG(e.score) FROM Entry e WHERE e.malId = ?1 AND e.score > 0")
    Optional<Double> averageScoreByMalId(long malId);

    // Get count for each watch status
    @Query("SELECT e.status, COUNT(*) FROM Entry e WHERE e.malId = ?1 GROUP BY e.status ORDER BY e.status")
    int[][] countStatusByMalId(long malId);

}