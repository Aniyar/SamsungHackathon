package com.hackathon.sic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Submission {
	@Id @GeneratedValue
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Assignment assignment;

	@ManyToOne(fetch=FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Student student;

	private LocalDate submissionDate;

	private String fileUrl;
}
