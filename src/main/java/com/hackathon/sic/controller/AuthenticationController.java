package com.hackathon.sic.controller;

import com.hackathon.sic.exception.IncorrectVerificationCodeException;
import com.hackathon.sic.exception.UserAlreadyExistsException;
import com.hackathon.sic.exception.UserNotFoundException;
import com.hackathon.sic.request.AuthenticationRequest;
import com.hackathon.sic.request.RegisterRequest;
import com.hackathon.sic.request.VerifyEmailRequest;
import com.hackathon.sic.response.AuthenticationResponse;
import com.hackathon.sic.response.UserInfoResponse;
import com.hackathon.sic.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.hackathon.sic.service.AuthenticationService;


import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) throws UserAlreadyExistsException {

    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/verify")
  public ResponseEntity<AuthenticationResponse> verify(
          @RequestBody VerifyEmailRequest request
  ) throws IncorrectVerificationCodeException, UserNotFoundException {
    return ResponseEntity.ok(service.verify(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }



}
