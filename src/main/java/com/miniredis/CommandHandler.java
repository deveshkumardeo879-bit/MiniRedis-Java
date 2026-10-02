package com.miniredis;

public class CommandHandler {

    private final KeyValueStore database;

    public CommandHandler(KeyValueStore database) {
        this.database = database;
    }

    public String execute(String command) {

        String[] parts = command.trim().split("\\s+");

        if (parts.length == 0) {
            return "ERROR: Empty command";
        }

        String operation = parts[0].toUpperCase();

        switch (operation) {

            case "SET":
                if (parts.length < 3) {
                    return "ERROR: SET requires key and value";
                }

                database.set(parts[1], parts[2]);
                return "OK";

            case "SETEX":
                if (parts.length != 4) {
                    return "ERROR: SETEX requires key, seconds and value";
                }

                try {
                    long seconds = Long.parseLong(parts[2]);

                    database.setWithTTL(parts[1], parts[3], seconds);

                    return "OK";

                } catch (NumberFormatException e) {
                    return "ERROR: Invalid seconds";
                }

            case "GET":
                if (parts.length != 2) {
                    return "ERROR: GET requires a key";
                }

                String value = database.get(parts[1]);

                if (value == null) {
                    return "(nil)";
                }

                return value;

            case "DEL":
                if (parts.length != 2) {
                    return "ERROR: DEL requires a key";
                }

                database.delete(parts[1]);
                return "OK";

            case "EXISTS":
                if (parts.length != 2) {
                    return "ERROR: EXISTS requires a key";
                }

                return database.exists(parts[1]) ? "1" : "0";

            case "PING":
                return "PONG";

            default:
                return "ERROR: Unknown command";
        }
    }
}