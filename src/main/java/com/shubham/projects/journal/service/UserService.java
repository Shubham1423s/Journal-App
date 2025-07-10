package com.shubham.projects.journal.service;

import com.shubham.projects.journal.controller.JournalEntryController;
import com.shubham.projects.journal.entity.JournalEntry;
import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private  static  final PasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger( UserService .class);
    // now we use slf4j toh inject this no need to write this now
    // make you put the same as you in  sometimes in copy pasting gwe forget to change the class
// we gonna use slf4j  through logpack we get it by abstraction



    public void saveEntry(User user){

        userRepository.save(user);

    }
    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user. setRoles (Arrays. asList("USER")) ;
            userRepository.save(user);
            return  true;

        }
        catch (Exception e){
            log.error ("Error occurred  sir {} :",user.getUserName(), e) ;
            log.info ("Error occurred  sir :",user.getUserName(), e); ;
            log.debug ("Error occurred  sir :",user.getUserName(), e); ;
            log.trace ("Error occurred  sir :",user.getUserName(), e); ;
            log.warn ("Error occurred  sir :",user.getUserName(), e); ;
            // we use this instead of sout so can customise things easily
            return  false;
        }



    }
    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user. setRoles (Arrays. asList("USER","ADMIN")) ;

        userRepository.save(user);

    }
    public List<User> getAll(){
        return userRepository.findAll();

    }

    public  void  deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public Optional<User> findById(ObjectId id){
        return  userRepository.findById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);

    }

}
