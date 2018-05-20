package com.logos.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.logos.entity.User;
import com.logos.repository.UserRepository;
import com.logos.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	


	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void saveUser(User user) {
		String password = user.getPassword();
		System.out.println("BEFORE: " + password);
		user.setPassword(passwordEncoder.encode(password));
		System.out.println("AFTER: " + user.getPassword());
		userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);
				
	}
	
	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	
	
}
