package com.github.donaldwilson8.repository;

import com.github.donaldwilson8.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByPhone(String phone);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
