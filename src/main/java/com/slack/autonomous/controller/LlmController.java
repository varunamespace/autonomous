package com.slack.autonomous.controller;

import com.slack.autonomous.service.LlmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LlmController {

    private final LlmService llmService;

    public LlmController(LlmService llmService) {
        this.llmService = llmService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String conversationId,@RequestParam String question) {
        return llmService.ask(conversationId,question);
    }
}