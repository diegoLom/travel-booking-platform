package com.losolved.user.services;


import com.losolved.user.model.User;
import com.losolved.user.repositories.UserRepository;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest()
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest
{

    @Mock
    private  UserRepository userRepository;

    private  UserService userService;

    @BeforeAll
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void valid(){

         doReturn(getMockedUser(1l)).when(userRepository).findById(1l);
         Optional<User> optionalUser = userService.getUser(1l);

         if(optionalUser.isPresent()){
             User user = optionalUser.get();
             assertEquals(user.getUserId(), 1l);
         }


    }


    public Optional<User> getMockedUser(Long userId){
        User user = User.builder().userId(userId).build();
        user.setUserId(userId);
        user.setUserName("Diego_Delicinha");


        return Optional.of(user);
    }




}
