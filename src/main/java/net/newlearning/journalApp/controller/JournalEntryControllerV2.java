package net.newlearning.journalApp.controller;

import net.newlearning.journalApp.Entity.JournalEntry;
import net.newlearning.journalApp.Entity.User;
import net.newlearning.journalApp.service.JournalEntryService;
import net.newlearning.journalApp.service.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {



@Autowired
private JournalEntryService journalEntryService;
@Autowired
private UserServices userServices;


    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userServices.findByUserName(username);
    List<JournalEntry> all = user.getJournalEntryList();
    if(all != null && !all.isEmpty()){
        return  new ResponseEntity<>(all, HttpStatus.OK);

    }
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry myentry) {
//        myentry.setDate(LocalDateTime.now());
//        journalEntryService.saveEntry(myentry);
//            return  myentry;
//    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry ) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            myentry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myentry,username);
            return  new ResponseEntity<>(myentry, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
         User user = userServices.findByUserName(username);
        List<JournalEntry> collect =  user.getJournalEntryList().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
       if(!collect.isEmpty()) {
           Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
           if (journalEntry.isPresent()) {
               return new ResponseEntity<>(journalEntry.get(), HttpStatus.valueOf(200));
           }
       }
        return  new ResponseEntity<>(HttpStatus.valueOf(404));
    }

//    @DeleteMapping("id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
//      journalEntryService.deleteById(myId);
//      return true;
//    }


    @DeleteMapping("id/{username}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean removed = journalEntryService.deleteById(myId, username);
        if (removed) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


//    @PutMapping("id/{Id}")
//    public  JournalEntry updateJournalEntryById(@PathVariable ObjectId Id,  @RequestBody JournalEntry myEntry){
//        JournalEntry old =  journalEntryService.findById(Id).orElse(null);
//        if(old != null) {
//            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals(" ") ? myEntry.getTitle() : old.getTitle());
//            old.setContent(myEntry.getContent() != null && !myEntry.getContent().equals(" ") ? myEntry.getContent(): old.getContent());
//        }
//            journalEntryService.saveEntry(old);
//            return old;
//
//    }


    @PutMapping("id/{Id}")
    public  ResponseEntity<JournalEntry>  updateJournalEntryById(@PathVariable ObjectId Id,
                                                                 @RequestBody JournalEntry myEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userServices.findByUserName(username);
        List<JournalEntry> collect = user.getJournalEntryList().stream().filter(x -> x.getId().equals(Id)).collect(Collectors.toList());

        if (!collect.isEmpty()) {
            Optional<JournalEntry> journalEntry = journalEntryService.findById(Id);
            if (journalEntry.isPresent()) {
                JournalEntry old = journalEntry.get();

                old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals(" ") ? myEntry.getTitle() : old.getTitle());
                old.setContent(myEntry.getContent() != null && !myEntry.getContent().equals(" ") ? myEntry.getContent() : old.getContent());

                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old, HttpStatus.OK);
            }

        }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
