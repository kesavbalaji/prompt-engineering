package com.prompt.openai.controller;

import com.prompt.openai.serviceImpl.PromptServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PromptController {

    private final static Logger logger = LoggerFactory.getLogger(PromptController.class);

    @Autowired
    private PromptServiceImpl promptService;

    @GetMapping("/getPromptMessage")
    public ResponseEntity<String> getMessage(String prompt) {
        try {
            return promptService.generateResponse(prompt);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
