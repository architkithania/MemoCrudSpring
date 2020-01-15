package com.simpleapp.crud.repository;

import com.simpleapp.crud.modals.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
}
