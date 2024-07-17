package com.example.our_anime_list.service;

import com.example.our_anime_list.entity.Entry;
import com.example.our_anime_list.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    EntryRepository repo;

    public Entry addEntry(Entry entry) {
        return repo.save(entry);
    }

    public Entry getEntryById(long id){
        return repo.findById(id).orElse(null);
    }

    public List<Entry> getEntriesByUserId(long userId) {
        return repo.findByUserId(userId);
    }

    public List<Entry> getEntriesByMalId(long malId) {
        return repo.findByMalId(malId);
    }

    public Entry getEntryByUserIdAndMalId(long userId, long malId) {
        return repo.findByUserIdAndMalId(userId, malId).orElse(null);
    }

    public List<Entry> getFavoriteEntriesByUserId(long userId){
        return repo.findByUserIdAndFavoriteTrue(userId);
    }

    public List<Entry> getAll() {
        return repo.findAll();
    }

    public Entry updateEntry(Entry entry) {
        return repo.save(entry);
    }

    public void deleteEntryById(long id) {
        repo.deleteById(id);
    }

}
