package com.losolved.user.services;

import com.losolved.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Optional<User> getUser(Long i);
    public List<User> get();

    public void unRengister(User user);

    public User register(User user);

    public Optional<User> update(User user);

    public User login(String userName, String password);


}
