package com.te.lms.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.security.AuthenticationRequest;
import com.te.lms.dto.security.AuthenticationResponse;
import com.te.lms.jwtutil.JwtUtil;

@RestController("/lms/v1/security")
public class SecurityController {

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authorize")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest request) {

		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (BadCredentialsException e) {
			e.printStackTrace();
		}

		UserDetails userDetails = detailsService.loadUserByUsername(request.getUserName());
		String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.OK);

	}
}
