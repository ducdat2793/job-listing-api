package com.example.job_listing_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.job_listing_api.model.User;
import com.example.job_listing_api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword())); // mã hóa mật khẩu
		return userRepository.save(user);
	}

}
