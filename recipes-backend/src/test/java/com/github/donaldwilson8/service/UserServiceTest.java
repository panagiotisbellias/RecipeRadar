package com.github.donaldwilson8.service;

import com.github.donaldwilson8.exception.CustomExceptions;
import com.github.donaldwilson8.model.User;
import com.github.donaldwilson8.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @Test
    void testConstructor() {
        UserService userService = new UserService(userRepository);
        Assertions.assertInstanceOf(UserService.class, userService);
    }

    @Test
    void testGetAllUsers() {
        Assertions.assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById() {
        Assertions.assertNull(userService.getUserById("id"));
    }

    @Test
    void testGetUserByUsername() {
        Assertions.assertNull(userService.getUserByUsername("username"));
    }

    @Test
    void testCreateUser() {
        Assertions.assertNull(userService.createUser(user));
    }

    @Test
    void testCreateUserExistingUsername() {
        Mockito.when(user.getUsername()).thenReturn("username");
        Mockito.when(userRepository.existsByUsername("username")).thenReturn(true);

        CustomExceptions.DuplicateUserException exception = Assertions.assertThrows(CustomExceptions.DuplicateUserException.class, () -> userService.createUser(user));
        Assertions.assertEquals("Username is already taken.", exception.getMessage());
    }

    @Test
    void testCreateUserExistingEmail() {
        Mockito.when(user.getEmail()).thenReturn("email");
        Mockito.when(userRepository.existsByEmail("email")).thenReturn(true);

        CustomExceptions.DuplicateUserException exception = Assertions.assertThrows(CustomExceptions.DuplicateUserException.class, () -> userService.createUser(user));
        Assertions.assertEquals("Email is already in use.", exception.getMessage());
    }

    @Test
    void testUpdateUser() {
        Mockito.when(user.get_id()).thenReturn("id");
        Mockito.when(user.getAge()).thenReturn(1);
        Mockito.when(user.getEmail()).thenReturn("email");
        Mockito.when(user.getGender()).thenReturn("gender");
        Mockito.when(user.getName()).thenReturn("name");
        Mockito.when(user.getPassword()).thenReturn("password");
        Mockito.when(user.getPhone()).thenReturn("phone");
        Mockito.when(user.getDietaryRestrictions()).thenReturn(new String[]{});
        Mockito.when(userRepository.findById("id")).thenReturn(Optional.of(user));
        Assertions.assertNull(userService.updateUser(user));
    }

    @Test
    void testUpdateUserNull() {
        Mockito.when(user.get_id()).thenReturn("id");
        Mockito.when(userRepository.findById("id")).thenReturn(Optional.of(user));
        Assertions.assertNull(userService.updateUser(user));
    }

    @Test
    void testUpdateUserAbsent() {
        CustomExceptions.UserNotFoundException exception = Assertions.assertThrows(CustomExceptions.UserNotFoundException.class, () -> userService.updateUser(user));
        Assertions.assertEquals("User not found with id: null", exception.getMessage());
    }

}
