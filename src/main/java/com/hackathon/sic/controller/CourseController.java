package com.hackathon.sic.controller;

import com.hackathon.sic.dto.CourseDTO;
import com.hackathon.sic.dto.CourseFullDTO;
import com.hackathon.sic.exception.CourseNotFoundException;
import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.StudentNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.model.Course;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {

	private final CourseService service;

	@GetMapping
	public ResponseEntity<Iterable<CourseDTO>> getCourses(){
		return ResponseEntity.ok(service.getAllCourses());
	}


	@GetMapping("/full")
	public ResponseEntity<CourseFullDTO> getFullCourseById(@RequestParam Integer courseId) throws CourseNotFoundException {
		return ResponseEntity.ok(service.getFullCourseById(courseId));
	}








}
