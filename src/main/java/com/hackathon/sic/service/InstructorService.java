package com.hackathon.sic.service;

import com.hackathon.sic.dto.CourseDTO;
import com.hackathon.sic.dto.CourseFullDTO;
import com.hackathon.sic.exception.CourseNotFoundException;
import com.hackathon.sic.exception.InstructorNotAuthorizedException;
import com.hackathon.sic.exception.InstructorNotFoundException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.model.Course;
import com.hackathon.sic.model.Instructor;
import com.hackathon.sic.model.Lesson;
import com.hackathon.sic.repository.CourseRepository;
import com.hackathon.sic.repository.InstructorRepository;
import com.hackathon.sic.repository.LessonRepository;
import com.hackathon.sic.repository.UserRepository;
import com.hackathon.sic.request.AddCourseRequest;
import com.hackathon.sic.request.AddLessonRequest;
import com.hackathon.sic.user.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InstructorService {

	private final InstructorRepository instructorRepository;
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final ModelMapper modelMapper;
	private final LessonRepository lessonRepository;

	public void addCourse(UserDetails userDetails, AddCourseRequest request) throws UserNotFoundException, InstructorNotFoundException {
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Instructor instructor = instructorRepository.findByUser_Id(user.getId()).orElseThrow(InstructorNotFoundException::new);
		Course course = Course.builder()
				.courseName(request.getCourseName())
				.description(request.getDescription())
				.courseType(request.getCourseType())
				.startDate(request.getStartDate())
				.endDate(request.getEndDate())
				.instructors(Set.of(instructor))
				.build();
		courseRepository.save(course);
	}

	public Iterable<CourseDTO> getCourses(UserDetails userDetails) throws UserNotFoundException, InstructorNotFoundException {
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Instructor instructor = instructorRepository.findByUser_Id(user.getId()).orElseThrow(InstructorNotFoundException::new);

		Iterable<Course> courses = instructor.getCourses();
		TypeToken<List<CourseDTO>> typeToken = new TypeToken<List<CourseDTO>>() {};
		return modelMapper.map(courses, typeToken.getType());
	}

	public CourseFullDTO getFullCourseById(Integer courseId) throws CourseNotFoundException {
		Course course = courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
		return modelMapper.map(course, CourseFullDTO.class);
	}

	public void addLesson(UserDetails userDetails, AddLessonRequest request) throws InstructorNotAuthorizedException, CourseNotFoundException, UserNotFoundException, InstructorNotFoundException {
		Course course = courseRepository.findById(request.getCourseId()).orElseThrow(CourseNotFoundException::new);
		User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
		Instructor instructor = instructorRepository.findByUser_Id(user.getId()).orElseThrow(InstructorNotFoundException::new);
		if (!course.getInstructors().contains(instructor)) throw new InstructorNotAuthorizedException();

		Lesson lesson = Lesson.builder()
				.course(course)
				.lessonTitle(request.getLessonTitle())
				.lessonDescription(request.getLessonDescription())
				.lessonTime(request.getLessonTime())
				.build();
		lessonRepository.save(lesson);

	}
}
