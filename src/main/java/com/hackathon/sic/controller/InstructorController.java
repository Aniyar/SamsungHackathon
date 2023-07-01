package com.hackathon.sic.controller;

import com.hackathon.sic.dto.CourseFullDTO;
import com.hackathon.sic.exception.CourseNotFoundException;
import com.hackathon.sic.exception.InstructorNotAuthorizedException;
import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.request.AddLessonRequest;
import com.hackathon.sic.service.InstructorService;
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
	@PostMapping("courses/addLesson")
	public ResponseEntity addLesson(@AuthenticationPrincipal UserDetails userDetails,
	                                @RequestBody AddLessonRequest request) throws UserNotFoundException, InstructorNotFoundException, InstructorNotAuthorizedException, CourseNotFoundException {
		service.addLesson(userDetails, request);
		return ResponseEntity.ok().build();
	}

}
