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
    List<Entry> findByUserIdAndFavoriteTrue(long userId);

    @Query("SELECT COUNT(*) FROM Entry e WHERE e.malId = ?1")
    Optional<Integer> countByMalId(long malId);
    @Query("SELECT AVG(e.score) FROM Entry e WHERE e.malId = ?1")
    Optional<Double> averageScoreByMalId(long malId);

    @Query("SELECT AVG(e.score) FROM Entry e WHERE e.userId = ?1")
    Optional<Double> averageScoreByUserId(long userId);

    @Query("SELECT SUM(e.totalEpisodes) FROM Entry e WHERE e.user.Id =?1")
    Optional<Integer> totalEpisodesWatchedByUserId(long userId);


}