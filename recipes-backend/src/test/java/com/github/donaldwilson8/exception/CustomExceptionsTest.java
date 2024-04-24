package com.github.donaldwilson8.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomExceptionsTest {

    @Test
    void testUserNotFoundException() {
        CustomExceptions.UserNotFoundException userNotFoundException = Mockito.mock(CustomExceptions.UserNotFoundException.class);
        Mockito.when(userNotFoundException.getMessage()).thenReturn("User not found!");
        Assertions.assertEquals("User not found!", userNotFoundException.getMessage());
    }

    @Test
    void testDuplicateUserException() {
        CustomExceptions.DuplicateUserException duplicateUserException = Mockito.mock(CustomExceptions.DuplicateUserException.class);
        Mockito.when(duplicateUserException.getMessage()).thenReturn("Duplicate user found!");
        Assertions.assertEquals("Duplicate user found!", duplicateUserException.getMessage());
    }

    @Test
    void testEdamamApiException() {
        CustomExceptions.EdamamApiException edamamApiException = Mockito.mock(CustomExceptions.EdamamApiException.class);
        Mockito.when(edamamApiException.getMessage()).thenReturn("Edamam API exception!");
        Assertions.assertEquals("Edamam API exception!", edamamApiException.getMessage());
    }

}
