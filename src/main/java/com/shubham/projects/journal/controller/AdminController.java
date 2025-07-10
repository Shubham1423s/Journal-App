package com.shubham.projects.journal.controller;

import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")// it stores like ROLE_ADMIN
    @GetMapping("/all-users")
   public ResponseEntity<List<User>> getAllUser(){
        List<User> all = userService.getAll();
        if (all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);

        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create-admin-user")
    public  void createUser(@RequestBody User user){
       userService.saveAdmin(user);
    }

}
