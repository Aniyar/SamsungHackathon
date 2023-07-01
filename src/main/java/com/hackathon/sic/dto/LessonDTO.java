package com.hackathon.sic.dto;


import com.hackathon.sic.model.Course;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {
	private Integer id;
	private String lessonTitle;
	private String lessonDescription;
}
