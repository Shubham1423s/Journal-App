package com.shubham.projects.journal.service;

import com.shubham.projects.journal.entity.JournalEntry;
import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private  UserService userService;


   @Transactional
   public void saveEntry(JournalEntry journalEntry, String userName){
       try {
           User user = userService.findByUserName(userName);
           JournalEntry saved = journalEntryRepository.save(journalEntry);
           user.getJournalEntries().add(saved);
//        user.setUserName(null);
           // suppose if there is a issue in this place so journal is saved but it will not saved in user
           // means it is not associated with the user
           // sp it shows in the database there is an entry but not in the user data

           // so in that case we use Transitional annotation if anything fail in this method then all the things should be fail nothing
           // will run  so in this case journal entry will not save if er don't able to save in the user
           // if we put transactional then it will tell spring that  treat this method as single operation

           // basically and operator true true then true else false

           userService.saveEntry(user);


       }
       catch (Exception e){
           System.out.println("Exception"+e);
           throw  new RuntimeException("An error occurred  while saving the entry",e);
       }

    }
    public void saveEntry(JournalEntry journalEntry){

       journalEntryRepository.save(journalEntry);

    }
    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();

    }

    @Transactional
    public  boolean  deleteEntry(ObjectId id, String userName){

       boolean removed = false;

       try {
           User user = userService.findByUserName(userName);
            removed =  user.getJournalEntries().removeIf(x -> x.getId().equals(id));

           if(removed){
               userService.saveEntry(user);
               journalEntryRepository.deleteById(id);

           }
       }
       catch (Exception e){
           System.out.println("exception");
           throw  new RuntimeException("An error occured while deleting  the entry", e);
       }
       return removed;


    }

    public Optional<JournalEntry> getEntry(ObjectId id){
       return  journalEntryRepository.findById(id);
   }
//   public  Optional<JournalEntry> updateEntry(ObjectId id, JournalEntry updateEntry){
//        updateEntry.setId(id);
//        return  journalEntryRepository.save(updateEntry);
//   }







}
