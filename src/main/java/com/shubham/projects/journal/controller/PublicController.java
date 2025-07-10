package com.shubham.projects.journal.controller;

import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User myuser){

        try{
            userService.saveNewUser(myuser);
            return  new ResponseEntity<>(myuser, HttpStatus.CREATED);

        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        }
    }


}
