package com.miniredis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyValueStoreTest {

    @Test
    void shouldSetAndGetValue() {

        KeyValueStore database = new KeyValueStore();

        database.set("name", "Devesh");

        assertEquals("Devesh", database.get("name"));
    }

    @Test
    void shouldDeleteValue() {

        KeyValueStore database = new KeyValueStore();

        database.set("name", "Devesh");
        database.delete("name");

        assertNull(database.get("name"));
    }

    @Test
    void shouldCheckIfKeyExists() {

        KeyValueStore database = new KeyValueStore();

        database.set("name", "Devesh");

        assertTrue(database.exists("name"));
    }

    @Test
    void shouldReturnFalseForMissingKey() {

        KeyValueStore database = new KeyValueStore();

        assertFalse(database.exists("name"));
    }

    @Test
    void shouldExpireValueAfterTTL() throws InterruptedException {

        KeyValueStore database = new KeyValueStore();

        database.setWithTTL("temporary", "Hello", 1);

        assertEquals("Hello", database.get("temporary"));

        Thread.sleep(1100);

        assertNull(database.get("temporary"));
    }
}