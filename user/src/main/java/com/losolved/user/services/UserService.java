package com.losolved.user.services;

import com.losolved.user.model.User;
import com.losolved.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(Long i) {
        return userRepository.findById(i);
    }

    @Override
    public List<User> get() {
        return null;
    }

    @Override
    public void unRengister(User user) {

    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User login(String userName, String password) {
        return null;
    }
}
