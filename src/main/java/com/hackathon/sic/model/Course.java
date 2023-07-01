package com.hackathon.sic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue
	private Integer id;

	private String courseName;

	private String description;

	private CourseType courseType;

	private LocalDate startDate;
	private LocalDate endDate;


	@ManyToMany
	@JoinTable(name = "course_instructor",
			joinColumns = { @JoinColumn(name = "fk_course") },
			inverseJoinColumns = { @JoinColumn(name = "fk_instructor") })
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Instructor> instructors;

	@ManyToMany
	@JoinTable(name = "course_student",
			joinColumns = { @JoinColumn(name = "fk_course") },
			inverseJoinColumns = { @JoinColumn(name = "fk_student") })
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Student> students;


	@OneToMany(mappedBy="course")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Lesson> lessons;


	@OneToMany(mappedBy="course")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Assignment> assignments;



}
