package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        Assertions.assertInstanceOf(User.class, user);
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User("_id", "username", "password", "email", "phone", "name", 0, "gender", new String[]{"dietary restriction"});
        Assertions.assertEquals("_id", user.get_id());
        Assertions.assertEquals("username", user.getUsername());
        Assertions.assertEquals("password", user.getPassword());
        Assertions.assertEquals("email", user.getEmail());
        Assertions.assertEquals("phone", user.getPhone());
        Assertions.assertEquals("name", user.getName());
        Assertions.assertEquals(0, user.getAge());
        Assertions.assertEquals("gender", user.getGender());

        String[] dietaryRestrictions = user.getDietaryRestrictions();
        Assertions.assertEquals(1, dietaryRestrictions.length);
        Assertions.assertEquals("dietary restriction", dietaryRestrictions[0]);
    }

    @Test
    void testSetters() {
        User user = new User();
        user.set_id("_id");
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setName("name");
        user.setAge(0);
        user.setGender("gender");
        user.setDietaryRestrictions(new String[]{"dietary restriction"});

        Assertions.assertEquals("_id", user.get_id());
        Assertions.assertEquals("username", user.getUsername());
        Assertions.assertEquals("password", user.getPassword());
        Assertions.assertEquals("email", user.getEmail());
        Assertions.assertEquals("phone", user.getPhone());
        Assertions.assertEquals("name", user.getName());
        Assertions.assertEquals(0, user.getAge());
        Assertions.assertEquals("gender", user.getGender());

        String[] dietaryRestrictions = user.getDietaryRestrictions();
        Assertions.assertEquals(1, dietaryRestrictions.length);
        Assertions.assertEquals("dietary restriction", dietaryRestrictions[0]);
    }

}
