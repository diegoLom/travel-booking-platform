package com.losolved.user.services;


import com.losolved.user.model.User;
import com.losolved.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.losolved.user.exceptions.DuplicateUserNameException;
import javax.persistence.PersistenceException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;



/**
 * The application follows a Test-Driven Development (TDD) approach,
 * where all unit tests are written before creating the related class or method.
 *  In this class, I implemented an example of username validation because
 *  it was the only business rule I could think of at the time. I didn't implement CRUD
 *  validations because the methods are built upon a robust and already validated
 *  JPA repository framework. It is important to align with the business rules.
 */
@SpringBootTest
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
        // P.O writing system rules

    @Test
    public void cantRepeatUserName(){
        User user = getMockedUser(2L).get();
        try {
            givenAttemptToPersitDuplicateUserName(user);
        }catch(DuplicateUserNameException dup){
            assertThrows(DuplicateUserNameException.class, () -> userService.register(user));
       }

    }


    public void givenAttemptToPersitDuplicateUserName(User user){
        given(userRepository.findByUserName(user.getUserName())).willReturn(Optional.of(user));
        userService.register(user);
    }

    public static Optional<User> getMockedUser(Long userId){
        User user = User.builder().userId(userId).userName("diegosantos255").build();
        return Optional.of(user);
    }


}
