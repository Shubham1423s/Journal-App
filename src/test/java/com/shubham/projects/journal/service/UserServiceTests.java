package com.shubham.projects.journal.service;

import com.shubham.projects.journal.entity.User;
import com.shubham.projects.journal.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
   private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp(){

    }

  @ParameterizedTest
  @ArgumentsSource(UserArgumentProvider.class )
    public  void testSaveNewUser(User user){

           assertTrue(userService.saveNewUser(user));

//        assertNotNull(userRepository.findByUserName("shubham"));

    }



   @Disabled
   @ParameterizedTest
   @CsvSource({
           "1,1,2",
           "12,11,23",
           "3,3,6"
   })

   public  void test( int a, int b,int expexted){
        assertEquals(expexted,a+b);
    }
}
