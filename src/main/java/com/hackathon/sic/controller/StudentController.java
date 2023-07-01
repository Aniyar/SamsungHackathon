package com.hackathon.sic.controller;

import com.hackathon.sic.dto.CourseDTO;
import com.hackathon.sic.exception.CourseNotFoundException;
import com.hackathon.sic.exception.StudentNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.service.CourseService;
import com.hackathon.sic.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {
	private final CourseService courseService;
	private final StudentService studentService;
	@PutMapping("/register")
	public ResponseEntity registerCourse(@RequestParam Integer courseId,
	                                     @AuthenticationPrincipal UserDetails userDetails)
			throws CourseNotFoundException, UserNotFoundException, StudentNotFoundException {
		courseService.registerCourse(courseId, userDetails);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/courses")
	public ResponseEntity<Iterable<CourseDTO>> getCourses(@AuthenticationPrincipal UserDetails userDetails) throws UserNotFoundException, StudentNotFoundException {
		return ResponseEntity.ok(studentService.getCourses(userDetails));
	}

}
