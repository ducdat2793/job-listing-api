package com.example.job_listing_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_listing_api.dto.AuthRequest;
import com.example.job_listing_api.dto.AuthResponse;
import com.example.job_listing_api.dto.UserRequest;
import com.example.job_listing_api.model.User;
import com.example.job_listing_api.service.UserService;
import com.example.job_listing_api.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Operation(summary = "Register user")
	@PostMapping("/register")
	public User registerUser(@RequestBody UserRequest userRequest) {
    	User user = new User();
    	user.setUsername(userRequest.getUsername());
    	user.setPassword(userRequest.getPassword());
    	user.setRole(userRequest.getRole());
		return userService.saveUser(user);
	}
	
    @Operation(summary = "Login")
	@PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }

}
