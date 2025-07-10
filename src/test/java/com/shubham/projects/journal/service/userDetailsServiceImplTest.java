package com.shubham.projects.journal.service;

import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class userDetailsServiceImplTest {

   @InjectMocks
   private userDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsername(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("mohan").password("abc").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("mohan");
        Assertions.assertNotNull(user);
    }
}
