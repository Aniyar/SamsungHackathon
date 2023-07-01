package com.hackathon.sic.dto;

import com.hackathon.sic.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private Integer id;
	private String email;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING)
	private Role role;
}
