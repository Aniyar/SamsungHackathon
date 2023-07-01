package com.hackathon.sic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {
	@Id @GeneratedValue
	private Integer id;

	private String schoolName;
	private String city;
	private String address;

	@Enumerated(EnumType.STRING)
	private SchoolType schoolType;


	@OneToMany(mappedBy="school")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Instructor> instructors;

	@OneToMany(mappedBy="school")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Student> students;

}
