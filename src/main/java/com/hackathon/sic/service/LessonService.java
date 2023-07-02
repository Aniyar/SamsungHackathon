package com.hackathon.sic.service;

import com.hackathon.sic.dto.LessonDTO;
import com.hackathon.sic.exception.GPTNoResponseException;
import com.hackathon.sic.exception.LessonNotFoundException;
import com.hackathon.sic.model.Lesson;
import com.hackathon.sic.repository.LessonRepository;
import com.hackathon.sic.response.ChatResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonService {
	private final LessonRepository lessonRepository;
	private final ModelMapper modelMapper;
	private final GPTService gptService;

	public LessonDTO getLessonById(Integer id) throws LessonNotFoundException {
		Lesson lesson = lessonRepository.findById(id).orElseThrow(LessonNotFoundException::new);
		return modelMapper.map(lesson, LessonDTO.class);
	}

	public ChatResponse.Choice gptCreateTest(Integer lessonId) throws LessonNotFoundException, GPTNoResponseException {
		Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(LessonNotFoundException::new);
		String prompt = createTestBasedOnLessonPrompt(lesson);
		return gptService.chat(prompt);
	}


	public String createTestBasedOnLessonPrompt(Lesson lesson){
		return String.format("Я провел со своими учениками урок на тему %s. " +
						"Описание урока: %s. " +
						"Создай мне 10 вопросов, которые оценят знания учеников по этой теме.",
				lesson.getLessonTitle(), lesson.getLessonDescription());
	}
}
