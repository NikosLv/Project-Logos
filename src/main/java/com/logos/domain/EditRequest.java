package com.logos.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditRequest {
	
	private int id;
	
	//@NotEmpty(message="Field email must be full")
	private String email;
	
	@NotEmpty(message="Field password must be full")
	private String password;
	
	@NotEmpty(message="Enter your first name")
	private String firstName;
	
	@NotEmpty(message="Enter your last name")
	private String lastName;
	
	@Min(value=18, message="May not be less than 18")
	@Max(value=70, message="Can not be greater than 70")
	private int age;
	
	@NotEmpty(message="Enter your city")
	private String city;
	
	@NotEmpty (message="Field phoneNumber can not be empty")
	private String phoneNumber;
	
	private String role;
	

}
