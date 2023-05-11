package com.jung.utils;

import java.util.UUID;

public class RandomSessionIdGenerator {
    public static String generateSessionId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
