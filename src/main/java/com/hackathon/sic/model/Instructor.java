package com.hackathon.sic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Instructor {
	@Id @GeneratedValue
	private Integer id;

	@OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private School school;

	@ManyToMany(mappedBy="instructors")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Course> courses;
}
