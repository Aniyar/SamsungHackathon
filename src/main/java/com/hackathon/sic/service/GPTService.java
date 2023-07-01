package com.hackathon.sic.service;

import com.hackathon.sic.model.Lesson;
import com.hackathon.sic.request.ChatRequest;
import com.hackathon.sic.response.ChatResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GPTService {
	@Qualifier("openaiRestTemplate")
	@Autowired
	private RestTemplate restTemplate;

	@Value("${openai.model}")
	private String model;

	@Value("${openai.api.url}")
	private String apiUrl;
	public String chat(String prompt){
		ChatRequest request = new ChatRequest();
		request.setMessages(Arrays.asList(
				Map.of("role", "user", "content", prompt)
		));
		request.setModel(model);
		ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
		if (response == null) {
			return "No response";
		}
		return response.getChoices().get(0).getMessage().getContent();
	}

	public String generateExample(String prompt) {
		return chat(prompt + "Приведи несколько примеров");
	}

	public String generateExplanation(String prompt) {
		return chat(prompt + "Обьясни простыми словами");
	}


}
