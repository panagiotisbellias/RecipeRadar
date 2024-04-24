package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LinksTest {

    @InjectMocks
    Links links;

    @Mock
    Link self;

    @Mock
    Link next;

    @Test
    void testGetters() {
        Assertions.assertEquals(self, links.getSelf());
        Assertions.assertEquals(next, links.getNext());
    }

    @Test
    void testSetters() {
        links.setSelf(self);
        links.setNext(next);

        Mockito.verifyNoInteractions(self);
        Mockito.verifyNoInteractions(next);
    }

}
