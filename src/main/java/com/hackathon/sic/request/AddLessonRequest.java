package com.hackathon.sic.request;

import com.hackathon.sic.model.Course;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonRequest {
	private Integer courseId;
	private String lessonTitle;
	private String lessonDescription;
	private LocalDateTime lessonTime;
}
