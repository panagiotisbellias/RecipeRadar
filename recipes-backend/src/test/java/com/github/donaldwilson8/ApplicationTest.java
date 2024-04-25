package com.github.donaldwilson8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @Test
    void testMain() {
        Application.main(new String[]{});
        Assertions.assertTrue(true);
    }

}
