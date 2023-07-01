package com.hackathon.sic.service;

import com.hackathon.sic.dto.CourseDTO;
import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.StudentNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.model.Course;
import com.hackathon.sic.model.Instructor;
import com.hackathon.sic.model.Student;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.repository.StudentRepository;
import com.hackathon.sic.repository.UserRepository;
import com.hackathon.sic.user.User;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.MultiMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private StudentRepository studentRepository;

	public Iterable<CourseDTO> getCourses(UserDetails userDetails) throws UserNotFoundException, StudentNotFoundException {
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Student student = studentRepository.findByUser_Id(user.getId()).orElseThrow(StudentNotFoundException::new);

		Iterable<Course> courses = student.getCourses();
		TypeToken<List<CourseDTO>> typeToken = new TypeToken<List<CourseDTO>>() {};
		return modelMapper.map(courses, typeToken.getType());
	}
}
