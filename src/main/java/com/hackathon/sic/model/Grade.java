package com.hackathon.sic.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Grade {
	@Id @GeneratedValue
	private Integer id;

	@OneToOne
	private Submission submission;

	private Integer grade;

	@ManyToOne
	private Instructor instructor;

}
