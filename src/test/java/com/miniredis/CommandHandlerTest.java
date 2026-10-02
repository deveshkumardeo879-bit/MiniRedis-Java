package com.miniredis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {

    @Test
    void shouldSetAndGetValue() {

        KeyValueStore database = new KeyValueStore();
        CommandHandler handler = new CommandHandler(database);

        assertEquals("OK", handler.execute("SET name Devesh"));
        assertEquals("Devesh", handler.execute("GET name"));
    }

    @Test
    void shouldDeleteValue() {

        KeyValueStore database = new KeyValueStore();
        CommandHandler handler = new CommandHandler(database);

        handler.execute("SET name Devesh");

        assertEquals("OK", handler.execute("DEL name"));
        assertEquals("(nil)", handler.execute("GET name"));
    }

    @Test
    void shouldCheckExists() {

        KeyValueStore database = new KeyValueStore();
        CommandHandler handler = new CommandHandler(database);

        handler.execute("SET name Devesh");

        assertEquals("1", handler.execute("EXISTS name"));
        assertEquals("0", handler.execute("EXISTS unknown"));
    }

    @Test
    void shouldReturnPong() {

        KeyValueStore database = new KeyValueStore();
        CommandHandler handler = new CommandHandler(database);

        assertEquals("PONG", handler.execute("PING"));
    }

    @Test
    void shouldSetValueWithTTL() {

        KeyValueStore database = new KeyValueStore();
        CommandHandler handler = new CommandHandler(database);

        assertEquals(
                "OK",
                handler.execute("SETEX temporary 10 Hello")
        );

        assertEquals(
                "Hello",
                handler.execute("GET temporary")
        );
    }
}