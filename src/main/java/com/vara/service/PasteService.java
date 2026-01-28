package com.vara.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vara.entity.Paste;
import com.vara.exception.NotFoundException;
import com.vara.repository.PasteRepository;

@Service
public class PasteService {

    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    @Transactional
    public Paste fetch(String id, Instant now) {
        Paste paste = pasteRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        // TTL check
        if (paste.getExpiresAt() != null && now.isAfter(paste.getExpiresAt())) {
            throw new NotFoundException();
        }

        // max_views check
        if (paste.getMaxViews() != null &&
                paste.getViewCount() >= paste.getMaxViews()) {
            throw new NotFoundException();
        }

        // increment view count
        paste.setViewCount(paste.getViewCount() + 1);

        return pasteRepository.save(paste);
    }
}