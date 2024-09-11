//package net.newlearning.journalApp.controller;
//
//import net.newlearning.journalApp.Entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController { // Corrected class name
//
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll() {
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myentry) {
//        journalEntries.put(myentry.getId(), myentry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
//        return journalEntries.get(myId);
//    }
//    @PutMapping("id/{Id}")
//    public  JournalEntry updateJournalEntryById(@PathVariable Long Id,  @RequestBody JournalEntry myEntry){
//        return journalEntries.put(Id, myEntry);
//    }
//}
