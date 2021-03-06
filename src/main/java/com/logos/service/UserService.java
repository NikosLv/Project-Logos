package com.logos.service;

import java.util.List;
import com.logos.entity.User;



public interface UserService {

	void saveUser(User user);

	User findUserById(int id);
	
	User findUserByEmail(String email);
	
	List<User> findAllUsers();
	
	void updateUser(User user);
	
	void deleteUser(int id);
}
