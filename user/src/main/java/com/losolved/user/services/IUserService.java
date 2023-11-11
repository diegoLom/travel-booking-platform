package com.losolved.user.services;

import com.losolved.user.exceptions.DuplicateUserNameException;
import com.losolved.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Optional<User> getUser(Long i);
    public List<User> get();

    public void unRengister(User user);

    /*
     * TODO: Create a main class for UserValidation (UserValidationException)
     * It's possible create a class UserValiationException
     * Other class can inherit from that (DuplicateUserNameException / PassworInvalidException /
     * RGInvalidException )
     */

    public User register(User user);

    public User update(User user);

    public User login(String userName, String password);


}
