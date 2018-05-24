package com.logos.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.logos.domain.AddUserRequest;
import com.logos.domain.EditRequest;
import com.logos.entity.UserProfile;
import com.logos.entity.enums.UserRole;

public interface UserMapper {

	public static User toSecurityUser(com.logos.entity.User user) {
		// user.getEmail()
		return new User(
				user.getEmail(), 
				user.getPassword(), 
				AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}
	
	public static com.logos.entity.User registerRequestToUser(AddUserRequest request) {
		com.logos.entity.User user = new com.logos.entity.User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(UserRole.ROLE_USER);
		
		return user;
	}
	
	public static EditRequest userToEditRequest(com.logos.entity.User user) {
		EditRequest request = new EditRequest();
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		request.setFirstName(user.getUserProfile().getFirstName());
		request.setLastName(user.getUserProfile().getLastName());
		request.setAge(user.getUserProfile().getAge());
		request.setCity(user.getUserProfile().getCity());
		request.setPhoneNumber(user.getUserProfile().getPhoneNumber());
		request.setId(user.getId());
		request.setRole(user.getRole().getRole());
		
		
		return request;
	}
	
	public static com.logos.entity.User editReuqestToUser(EditRequest request) {
		com.logos.entity.User user = new com.logos.entity.User();
		UserProfile userProfile = new UserProfile();
		
		user.setId(request.getId());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		if(request.getRole().equals(UserRole.ROLE_ADMIN)) {
		user.setRole(UserRole.ROLE_ADMIN);
		} else {
				user.setRole(UserRole.ROLE_USER);
			}
		
		userProfile.setId(request.getId());
		userProfile.setFirstName(request.getFirstName());
		userProfile.setLastName(request.getLastName());
		userProfile.setAge(request.getAge());
		userProfile.setCity(request.getCity());
		userProfile.setPhoneNumber(request.getPhoneNumber());
		
		user.setUserProfile(userProfile);
		return user;
	}	
	
}
