package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.Entry;
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
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @Autowired
    UserService userService;

    @PostMapping()
    public Entry addEntry(@RequestBody Entry entry) {
        entry.setId(0); // Ensure that ID is auto-generated

        // From security context, get username so that we can get user ID
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        entry.setUserId(userService.getByUsername(username).getId());

        return entryService.addEntry(entry);
    }

    @GetMapping()
    public ArrayList<Entry> getEntriesByUserId(@RequestBody long userId) {
        return (ArrayList<Entry>) entryService.getEntriesByUserId(userId);
    }

    @GetMapping("/all")
    public ArrayList<Entry> getAllEntries() {
        return (ArrayList<Entry>) entryService.getAll();
    }

    @PutMapping()
    public Entry updateEntry(@RequestBody Entry entry) {
        return entryService.updateEntry(entry);
    }

    @DeleteMapping()
    public ResponseEntity deleteEntryById(@RequestBody long id) {
        entryService.deleteEntryById(id);
        return new ResponseEntity(HttpStatusCode.valueOf(204));
    }

}
