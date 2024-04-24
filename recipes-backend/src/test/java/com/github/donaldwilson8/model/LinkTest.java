package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LinkTest {

    @Test
    void testLink() {
        Link link = new Link();
        link.setHref("href");
        link.setTitle("title");

        Assertions.assertEquals("href", link.getHref());
        Assertions.assertEquals("title", link.getTitle());
    }

}
