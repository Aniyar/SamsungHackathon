package com.hackathon.sic.dto;

import com.hackathon.sic.model.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseFullDTO {
	private Integer id;
	private String courseName;
	private String description;
	private CourseType courseType;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<InstructorDTO> instructors;
	private List<LessonDTO> lessons;
}
