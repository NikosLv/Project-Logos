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
@CheckPasswordMatch
public class AddUserRequest {


	
	@NotEmpty 
	@CheckIfEmailExists
	private String email;
	
	@NotEmpty 
	@NotEmpty 
	private String password;
	
	@NotEmpty
	@NotEmpty 
	private String passwordConfirmation;

}
