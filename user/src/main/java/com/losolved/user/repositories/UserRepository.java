package com.losolved.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.losolved.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
