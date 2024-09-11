package net.newlearning.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.newlearning.journalApp.Entity.JournalEntry;
import net.newlearning.journalApp.Entity.User;
import net.newlearning.journalApp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserServices userServices;

   private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        try {
            User user = userServices.findByUserName(username);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry savedEntry = journalEntryRepository.save(journalEntry);

            user.getJournalEntryList().add(savedEntry);
            userServices.saveUser(user);
        } catch (Exception e) {
            logger.info("haahaha");
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry", e);
        }
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user = userServices.findByUserName(username);
            removed = user.getJournalEntryList().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userServices.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            logger.error("Error");
            throw new RuntimeException("An error occurred while deleting the entry", e);
        }
        return removed;
    }
}

// controller ------> services
