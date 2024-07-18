package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.Entry;
import com.example.our_anime_list.entity.WatchStatus;
import com.example.our_anime_list.service.EntryService;
import com.example.our_anime_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class EntryController {

    @Autowired
    EntryService entryService;

    @Autowired
    UserService userService;

    @PostMapping("/entry")
    public ResponseEntity addEntry(@RequestBody Entry entry) {

        // Check if MalID is valid
        if (entry.getMalId() <= 0)
            return ResponseEntity.status(400).body("Error: MAL ID must be at least 1");

        // From security context, get username so that we can get user ID
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        entry.setUserId(userService.getByUsername(username).getId());

        // Check if user already has this anime in their list
        if (entryService.getEntryByUserIdAndMalId(entry.getUserId(), entry.getMalId()) != null)
            return ResponseEntity.status(400).body("Error: Anime already present in list");

        // Data validation
        entry.setId(0); // Ensure that ID is auto-generated
        if (entry.getStatus() == null)
            entry.setStatus(WatchStatus.PLAN_TO_WATCH);
        if (entry.getScore() < 0)
            entry.setScore(0);
        if (entry.getScore() > 100)
            entry.setScore(100);
        if (entry.getGenres() == null)
            entry.setGenres(new String[]{});

        Entry result = entryService.addEntry(entry);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/users/{userId}/list")
    public ArrayList<Entry> getEntriesByUserId(@PathVariable long userId) {
        return (ArrayList<Entry>) entryService.getEntriesByUserId(userId);
    }

    @GetMapping("/users/{userId}/favorites")
    public ArrayList<Entry> getFavoriteEntriesByUserId(@PathVariable long userId) {
        return (ArrayList<Entry>) entryService.getFavoriteEntriesByUserId(userId);
    }

    // Only used for debugging
    @GetMapping("/entry")
    public ArrayList<Entry> getAllEntries() {
        return (ArrayList<Entry>) entryService.getAll();
    }

    @PutMapping("/entry")
    public Entry updateEntry(@RequestBody Entry entry) {
        return entryService.updateEntry(entry);
    }

    @DeleteMapping("/entry/{id}")
    public ResponseEntity deleteEntryById(@PathVariable long id) {
        entryService.deleteEntryById(id);
        return new ResponseEntity(HttpStatusCode.valueOf(204));
    }

}
