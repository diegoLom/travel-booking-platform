package com.losolved.user.controller;

import com.losolved.user.model.User;
import com.losolved.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> users(){
        List<User> users = userService.get();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
         user = userService.register(user);
         return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        Optional<User> oUpdatedUser = userService.update(user);
        HttpStatus status = oUpdatedUser.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(user, status);
    }


}
