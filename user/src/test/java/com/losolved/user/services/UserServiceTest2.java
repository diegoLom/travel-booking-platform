package com.losolved.user.services;


import com.losolved.user.model.User;
import com.losolved.user.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.BDDMockito.*;
@SpringBootTest()
public class UserServiceTest2
{

    private  UserService userService;

    @MockBean
    private  UserRepository userRepository;

    @Autowired
    public UserServiceTest2(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void valid(){
        given(userRepository.findById(1l)).willReturn(getMockedUser(1l));
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
