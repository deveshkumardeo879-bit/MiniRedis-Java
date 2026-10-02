package com.miniredis;

import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {

    private final Map<String, String> data = new HashMap<>();
    private final Map<String, Long> expirationTimes = new HashMap<>();

    public void set(String key, String value) {
        data.put(key, value);
        expirationTimes.remove(key);
    }

    public void setWithTTL(String key, String value, long seconds) {
        data.put(key, value);

        long expirationTime = System.currentTimeMillis()
                + (seconds * 1000);

        expirationTimes.put(key, expirationTime);
    }

    public String get(String key) {

        if (isExpired(key)) {
            delete(key);
            return null;
        }

        return data.get(key);
    }

    public void delete(String key) {
        data.remove(key);
        expirationTimes.remove(key);
    }

    public boolean exists(String key) {

        if (isExpired(key)) {
            delete(key);
            return false;
        }

        return data.containsKey(key);
    }

    private boolean isExpired(String key) {

        Long expirationTime = expirationTimes.get(key);

        if (expirationTime == null) {
            return false;
        }

        return System.currentTimeMillis() >= expirationTime;
    }
}