package com.github.donaldwilson8.controller;

import com.github.donaldwilson8.exception.CustomExceptions;
import com.github.donaldwilson8.model.User;
import com.github.donaldwilson8.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    User user;

    @Test
    void testConstructor() {
        UserController userController = new UserController(userService);
        Assertions.assertInstanceOf(UserController.class, userController);
    }

    @Test
    void testGetAllUsers() {
        Assertions.assertTrue(Objects.requireNonNull(userController.getAllUsers().getBody()).isEmpty());
    }

    @Test
    void testGetUserById() {
        Assertions.assertNull(userController.getUserById("id").getBody());
    }

    @Test
    void testSignup() {
        ResponseEntity<?> response = userController.signup(user);
        Assertions.assertNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testSignupException() {
        Mockito.when(userService.createUser(user)).thenThrow(CustomExceptions.DuplicateUserException.class);
        ResponseEntity<?> response = userController.signup(user);
        Assertions.assertNull(response.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testUpdateUserProfile() {
        ResponseEntity<?> response = userController.updateUserProfile("id", user);
        Assertions.assertNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testUpdateUserProfileException() {
        Mockito.when(userService.updateUser(user)).thenThrow(CustomExceptions.UserNotFoundException.class);
        ResponseEntity<?> response = userController.updateUserProfile("id", user);
        Assertions.assertNull(response.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
