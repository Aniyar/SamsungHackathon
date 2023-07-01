package com.hackathon.sic.model;

import com.hackathon.sic.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	@Id @GeneratedValue
	private Integer id;

	@OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;

	@OneToMany(mappedBy="student")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Submission> submissions;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private School school;


}
