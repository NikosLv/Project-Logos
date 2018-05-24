package com.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logos.entity.User;
import com.logos.mapper.UserMapper;
import com.logos.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("User name: " + email);
		User user = userRepository.findUserByEmail(email);
		if(user == null ) throw new UsernameNotFoundException("User is not registered");
		return UserMapper.toSecurityUser(user);
	}
	

}
