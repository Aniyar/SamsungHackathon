package com.hackathon.sic.controller;

import com.hackathon.sic.dto.CourseFullDTO;
import com.hackathon.sic.dto.LessonDTO;
import com.hackathon.sic.exception.*;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.request.AddLessonRequest;
import com.hackathon.sic.response.ChatResponse;
import com.hackathon.sic.service.GPTService;
import com.hackathon.sic.service.InstructorService;
import com.hackathon.sic.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructor")
@AllArgsConstructor
@PreAuthorize("hasRole('INSTRUCTOR')")
public class InstructorController {

	private final InstructorService service;
	private final LessonService lessonService;
	private final GPTService gptService;

	@PreAuthorize("hasAuthority('instructor:create')")
	@PostMapping("/addCourse")
	public ResponseEntity addCourse(@AuthenticationPrincipal UserDetails userDetails,
	                                @RequestBody AddCourseRequest request) throws UserNotFoundException, InstructorNotFoundException {
		service.addCourse(userDetails, request);
		return ResponseEntity.ok().build();
	}

	@PreAuthorize("hasAuthority('instructor:read')")
	@GetMapping("/courses")
	public ResponseEntity getCourses(@AuthenticationPrincipal UserDetails userDetails) throws UserNotFoundException, InstructorNotFoundException {
		return ResponseEntity.ok(service.getCourses(userDetails));
	}

	@PreAuthorize("hasAuthority('instructor:read')")
	@GetMapping("/courses/full")
	public ResponseEntity<CourseFullDTO> getCourses(@RequestParam Integer courseId,
	                                                @AuthenticationPrincipal UserDetails userDetails) throws UserNotFoundException, InstructorNotFoundException, CourseNotFoundException {
		return ResponseEntity.ok(service.getFullCourseById(courseId));
	}


	@PreAuthorize("hasAuthority('instructor:create')")
	@PostMapping("/courses/addLesson")
	public ResponseEntity addLesson(@AuthenticationPrincipal UserDetails userDetails,
	                                @RequestBody AddLessonRequest request) throws UserNotFoundException, InstructorNotFoundException, InstructorNotAuthorizedException, CourseNotFoundException {
		service.addLesson(userDetails, request);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/courses/lessons/{lessonId}")
	public ResponseEntity<LessonDTO> getLesson(@PathVariable Integer lessonId) throws LessonNotFoundException {
		return ResponseEntity.ok(lessonService.getLessonById(lessonId));
	}

	@GetMapping("/gpt/createTest")
	public ResponseEntity<ChatResponse.Choice> gptCreateTest(@RequestParam Integer lessonId) throws LessonNotFoundException, GPTNoResponseException {
		return ResponseEntity.ok(lessonService.gptCreateTest(lessonId));
	}

	@GetMapping("/gpt/example")
	public ResponseEntity<ChatResponse.Choice> gptGenerateExample(@RequestParam String prompt) throws GPTNoResponseException {
		return ResponseEntity.ok(gptService.generateExample(prompt));
	}

	@GetMapping("/gpt/explanation")
	public ResponseEntity<ChatResponse.Choice> gptGenerateExplanation(@RequestParam String prompt) throws GPTNoResponseException {
		return ResponseEntity.ok(gptService.generateExplanation(prompt));
	}


}
