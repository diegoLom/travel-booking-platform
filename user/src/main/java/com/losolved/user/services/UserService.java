package com.losolved.user.services;

import com.losolved.user.model.User;
import com.losolved.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void unRengister(User user) {
        userRepository.delete(user);
    }

    @Override
    public User register(User user)  {
        preRegisterValidation(user);
        return userRepository.save(user);
    }

    public void preRegisterValidation(User user){
        UserValidationService.validateEmail(user);
        UserValidationService.validatePassword(user);
        UserValidationService.validateUserName(existUserWithSameName(user));
    }

    public boolean existUserWithSameName(User user) {
        Optional<User> oUser = userRepository.findByUserName(user.getUserName());
        return oUser.isPresent();
    }

    @Override
    public Optional<User> update(User user) {

        if(userRepository.existsById(user.getUserId())){
            return Optional.of(userRepository.save(user));
        }else{
            return Optional.empty();
        }

    }

    @Override
    public User login(String userName, String password) {
        return null;
    }
}
