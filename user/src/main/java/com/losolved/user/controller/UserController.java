package com.losolved.user.controller;

import com.losolved.user.model.User;
import com.losolved.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        List<User> users = userService.get();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user){
         user = userService.register(user);
         return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
