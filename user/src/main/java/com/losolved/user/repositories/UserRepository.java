package com.losolved.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.user.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   public Optional<User> findByUserName(String userName);

}
