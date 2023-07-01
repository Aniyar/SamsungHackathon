package com.hackathon.sic.controller;

import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.response.UserInfoResponse;
import com.hackathon.sic.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
	private final AuthenticationService service;

	@GetMapping("/getinfo")
	public ResponseEntity<UserInfoResponse> getInfo(
			@AuthenticationPrincipal UserDetails userDetails
	) throws UserNotFoundException {
		return ResponseEntity.ok(service.getInfo(userDetails));
	}
}
