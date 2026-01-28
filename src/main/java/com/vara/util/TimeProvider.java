package com.vara.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimeProvider {

    public Instant now(HttpServletRequest request) {

        // Read OS environment variable
        String testMode = System.getenv("TEST_MODE");

        if ("1".equals(testMode)) {
            String header = request.getHeader("x-test-now-ms");
            if (header != null) {
                return Instant.ofEpochMilli(Long.parseLong(header));
            }
        }

        // Normal runtime
        return Instant.now();
    }
}