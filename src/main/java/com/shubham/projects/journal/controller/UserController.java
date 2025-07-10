package com.shubham.projects.journal.controller;

import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.repository.UserRepository;
import com.shubham.projects.journal.service.UserService;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

   @Autowired
   private UserRepository userRepository;





//    @GetMapping("id/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable ObjectId id){
//        Optional<User> user =  userService.findById(id);
//
//        if(user.isPresent()){
//            return  new ResponseEntity<>( user.get(),HttpStatus.OK);
//        }
//        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
    @DeleteMapping
    public ResponseEntity<User> DeleteById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       userRepository.deleteByUserName(authentication.getName());

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<User> updateById(@RequestBody User newUser){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User  userOInDb = userService.findByUserName(userName);
        if(userOInDb != null){
            userOInDb.setUserName(newUser.getUserName());
            userOInDb.setPassword(newUser.getPassword());
            userService.saveEntry(userOInDb);
        }

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
