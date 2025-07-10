package com.shubham.projects.journal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthCheck {


    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }
    @GetMapping("/me")
    public ResponseEntity<String> getMe() {
        return ResponseEntity.ok("Current user: " + SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
