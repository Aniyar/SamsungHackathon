package com.hackathon.sic.controller;

import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
