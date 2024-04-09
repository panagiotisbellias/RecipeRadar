package com.github.donaldwilson8.service;

import com.github.donaldwilson8.exception.CustomExceptions;
import com.github.donaldwilson8.model.User;
import com.github.donaldwilson8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        logger.info("Calling getUserById with id: {}", id);
        logger.info("Result: {}", userRepository.findById(id).orElse(null));
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User newUser) throws CustomExceptions.DuplicateUserException {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new CustomExceptions.DuplicateUserException("Username is already taken.");
        }
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new CustomExceptions.DuplicateUserException("Email is already in use.");
        }
        return userRepository.save(newUser);
    }

    public User updateUser(User updatedUser) throws CustomExceptions.UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(updatedUser.get_id());
        if (!optionalUser.isPresent()) {
            throw new CustomExceptions.UserNotFoundException("User not found with id: " + updatedUser.get_id());
        }
        User user = optionalUser.get();

        if (updatedUser.getAge() != 0) user.setAge(updatedUser.getAge());
        if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
        if (updatedUser.getGender() != null) user.setGender(updatedUser.getGender());
        if (updatedUser.getName() != null) user.setName(updatedUser.getName());
        if (updatedUser.getPassword() != null) user.setPassword(updatedUser.getPassword());
        if (updatedUser.getPhone() != null) user.setPhone(updatedUser.getPhone());
        if (updatedUser.getDietaryRestrictions() != null) user.setDietaryRestrictions(updatedUser.getDietaryRestrictions());

        return userRepository.save(user);
    }

}
