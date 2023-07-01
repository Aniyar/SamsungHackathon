package com.hackathon.sic.service;

import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.model.Course;
import com.hackathon.sic.model.Instructor;
import com.hackathon.sic.repository.CourseRepository;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.repository.UserRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorService {

	private final InstructorRepository instructorRepository;
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;

	public void addCourse(UserDetails userDetails, AddCourseRequest request) throws UserNotFoundException, InstructorNotFoundException {
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Instructor instructor = instructorRepository.findByUser_Id(user.getId()).orElseThrow(InstructorNotFoundException::new);
		Course course = Course.builder()
				.courseName(request.getCourseName())
				.description(request.getDescription())
				.courseType(request.getCourseType())
				.startDate(request.getStartDate())
				.endDate(request.getEndDate())
				.instructors(List.of(instructor))
				.build();
		courseRepository.save(course);
	}
}
