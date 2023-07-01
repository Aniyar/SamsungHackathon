package com.hackathon.sic.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Lesson {
	@Id @GeneratedValue
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Course course;

	private String lessonTitle;

	private String lessonDescription;

	private LocalDateTime lessonTime;

}
