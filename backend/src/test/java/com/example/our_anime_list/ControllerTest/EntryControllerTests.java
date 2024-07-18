package com.example.our_anime_list.ControllerTest;

import com.example.our_anime_list.controller.EntryController;
import com.example.our_anime_list.entity.Entry;
import com.example.our_anime_list.entity.WatchStatus;
import com.example.our_anime_list.service.EntryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
public class EntryControllerTests {

    @Autowired
    EntryController entryController;

    @Autowired
    EntryService entryService;

    @Test
    void contextLoads() {
        assertThat(entryController).isNotNull();
        assertThat(entryService).isNotNull();
    }

    @Test
    void testCRUD() {

        //Test create
        Entry expectedEntry = new Entry(0, 1, 1, "test", 100, 5, WatchStatus.WATCHING, 80, false);
        Entry actualEntry = entryService.addEntry(expectedEntry);   //Entry Controller's addEntry() requires JWT, so directly call service instead

        assertEquals(expectedEntry, actualEntry);

        // Test read
        actualEntry = entryController.getEntriesByUserId(expectedEntry.getUserId()).get(0);
        assertEquals(expectedEntry, actualEntry);

        // Test update
        expectedEntry.setUserId(2);
        expectedEntry.setMalId(2);
        actualEntry = entryController.updateEntry(expectedEntry);
        assertEquals(expectedEntry, actualEntry);

        // Test delete
        long actualId = actualEntry.getId();
        entryController.deleteEntryById(actualId);
        assertEquals(0, entryController.getEntriesByUserId(actualId).size());

    }
}
