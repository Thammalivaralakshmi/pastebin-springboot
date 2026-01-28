package com.vara.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vara.repository.PasteRepository;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

/* 1️ GET /api/healthz */
@RestController
public class HealthController {

    private final PasteRepository pasteRepository;

    public HealthController(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    @GetMapping("/api/healthz")
    public Map<String, Boolean> health() {
        pasteRepository.count(); // DB connectivity check
        return Map.of("ok", true);
    }
}