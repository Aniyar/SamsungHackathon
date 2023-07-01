package com.hackathon.sic.service;

import com.hackathon.sic.dto.CourseDTO;
import com.hackathon.sic.exception.CourseNotFoundException;
import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.StudentNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.model.Course;
import com.hackathon.sic.model.Instructor;
import com.hackathon.sic.model.Student;
import com.hackathon.sic.repository.CourseRepository;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.repository.StudentRepository;
import com.hackathon.sic.repository.UserRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.user.User;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class CourseService {
	private final InstructorRepository instructorRepository;
	private final UserRepository userRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public Iterable<CourseDTO> getAllCourses() {
		Iterable<Course> courses = courseRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		TypeToken<List<CourseDTO>> typeToken = new TypeToken<List<CourseDTO>>() {};
		List<CourseDTO> courseDTOs = modelMapper.map(courses, typeToken.getType());

		return courseDTOs;
	}

	public Course getCourseById(Integer courseId) throws CourseNotFoundException {
		return courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
	}

	public void registerCourse(Integer courseId, UserDetails userDetails) throws StudentNotFoundException, UserNotFoundException, CourseNotFoundException {
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Student student = studentRepository.findByUser_Id(user.getId()).orElseThrow(StudentNotFoundException::new);
		Course course = courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
		course.getStudents().add(student);
	}
}
