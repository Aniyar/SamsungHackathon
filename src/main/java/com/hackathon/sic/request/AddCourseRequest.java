package com.hackathon.sic.request;

import com.hackathon.sic.model.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseRequest {
	private String courseName;
	private String description;
	private CourseType courseType;
	private LocalDate startDate;
	private LocalDate endDate;
}
