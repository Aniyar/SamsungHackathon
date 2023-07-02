package com.hackathon.sic.controller;

import com.hackathon.sic.exception.GPTNoResponseException;
import com.hackathon.sic.request.ChatRequest;
import com.hackathon.sic.response.ChatResponse;
import com.hackathon.sic.service.GPTService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("api/v1/chat")
public class ChatController {

    private GPTService gptService;

    @GetMapping
    public ResponseEntity<ChatResponse.Choice> chat(@RequestParam String prompt) throws GPTNoResponseException {
        // create a request
        return ResponseEntity.ok(gptService.chat(prompt));
    }
}