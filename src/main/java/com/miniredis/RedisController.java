package com.miniredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:63342")
public class RedisController {

    private static final Logger logger =
            LoggerFactory.getLogger(RedisController.class);

    private final KeyValueStore database = new KeyValueStore();

    @GetMapping("/get")
    public String get(@RequestParam String key) {

        logger.info("GET request received for key: {}", key);

        if (key == null || key.trim().isEmpty()) {
            logger.warn("GET rejected: empty key");
            return "ERROR: Key cannot be empty";
        }

        String value = database.get(key);

        if (value == null) {
            logger.info("Key not found: {}", key);
            return "(nil)";
        }

        logger.info("Key found: {}", key);

        return value;
    }

    @PostMapping("/set")
    public String set(
            @RequestParam String key,
            @RequestParam String value) {

        logger.info("SET request received for key: {}", key);

        if (key == null || key.trim().isEmpty()) {
            logger.warn("SET rejected: empty key");
            return "ERROR: Key cannot be empty";
        }

        if (value == null || value.trim().isEmpty()) {
            logger.warn("SET rejected: empty value");
            return "ERROR: Value cannot be empty";
        }

        database.set(key, value);

        logger.info("Value stored successfully for key: {}", key);

        return "OK";
    }

    @PostMapping("/setex")
    public String setWithTTL(
            @RequestParam String key,
            @RequestParam long seconds,
            @RequestParam String value) {

        logger.info("SETEX request received for key: {} with TTL: {} seconds",
                key, seconds);

        if (key == null || key.trim().isEmpty()) {
            logger.warn("SETEX rejected: empty key");
            return "ERROR: Key cannot be empty";
        }

        if (value == null || value.trim().isEmpty()) {
            logger.warn("SETEX rejected: empty value");
            return "ERROR: Value cannot be empty";
        }

        if (seconds <= 0) {
            logger.warn("SETEX rejected: invalid TTL");
            return "ERROR: TTL must be greater than 0";
        }

        database.setWithTTL(key, value, seconds);

        logger.info("Value stored with TTL successfully for key: {}", key);

        return "OK";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String key) {

        logger.info("DELETE request received for key: {}", key);

        if (key == null || key.trim().isEmpty()) {
            logger.warn("DELETE rejected: empty key");
            return "ERROR: Key cannot be empty";
        }

        database.delete(key);

        logger.info("Key deleted: {}", key);

        return "OK";
    }

    @GetMapping("/exists")
    public String exists(@RequestParam String key) {

        logger.info("EXISTS request received for key: {}", key);

        if (key == null || key.trim().isEmpty()) {
            logger.warn("EXISTS rejected: empty key");
            return "ERROR: Key cannot be empty";
        }

        boolean exists = database.exists(key);

        logger.info("EXISTS result for {}: {}", key, exists);

        return exists ? "1" : "0";
    }
}