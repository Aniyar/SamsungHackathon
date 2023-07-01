package com.hackathon.sic.dto;

import com.hackathon.sic.model.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDTO {
	private Integer id;
	private UserDTO user;
	private School school;
}
