package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.Entry;
import com.example.our_anime_list.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryService service;

    @PostMapping()
    public Entry addEntry(@RequestBody Entry entry) {
        entry.setId(0);
        return service.addEntry(entry);
    }

    @GetMapping()
    public ArrayList<Entry> getEntriesByUserId(@RequestBody long userId) {
        return (ArrayList<Entry>) service.getEntriesByUserId(userId);
    }

    @GetMapping("/all")
    public ArrayList<Entry> getAllEntries() {
        return (ArrayList<Entry>) service.getAll();
    }

    @PutMapping()
    public Entry updateEntry(@RequestBody Entry entry) {
        return service.updateEntry(entry);
    }

    @DeleteMapping()
    public ResponseEntity deleteEntryById(@RequestBody long id) {
        service.deleteEntryById(id);
        return new ResponseEntity(HttpStatusCode.valueOf(204));
    }

}
