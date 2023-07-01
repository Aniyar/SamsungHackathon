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
public class Assignment {
	@Id @GeneratedValue
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Course course;

	private String title;

	private String description;

	private LocalDate deadline;

	@OneToMany(mappedBy="assignment")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Submission> submissions;
}
