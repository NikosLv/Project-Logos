package com.logos.domain;

import javax.validation.constraints.NotEmpty;

import com.logos.validator.CheckIfEmailExists;
import com.logos.validator.CheckPasswordMatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@CheckPasswordMatch //(message = "your password is false!")
public class AddUserRequest {

	//@NotEmpty 
	//private String login;
	
	
	@NotEmpty 
	@CheckIfEmailExists 
	private String email;
	
	@NotEmpty 
	private String password;
	
	@NotEmpty 
	private String passwordConfirmation;

}
