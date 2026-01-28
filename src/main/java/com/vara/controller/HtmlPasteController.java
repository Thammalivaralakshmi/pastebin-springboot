package com.vara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vara.entity.Paste;
import com.vara.exception.NotFoundException;
import com.vara.service.PasteService;

import java.time.Instant;

@Controller
public class HtmlPasteController {

	private final PasteService pasteService;

	public HtmlPasteController(PasteService pasteService) {
		this.pasteService = pasteService;
	}

	@GetMapping("/p/{id}")
	public String viewPaste(@PathVariable String id, Model model) {

		Paste paste = pasteService.fetch(id, Instant.now());

		model.addAttribute("content", paste.getContent());

		return "paste"; // resolves to /WEB-INF/views/paste.jsp
	}

	@ExceptionHandler(NotFoundException.class)
	public String handleNotFound() {
		return "404"; // maps to /WEB-INF/views/404.jsp
	}
}