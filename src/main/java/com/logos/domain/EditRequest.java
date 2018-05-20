package com.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditRequest {
	
	private int id;
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String city;
	
	private String phoneNumber;
	
	private String role;
	

}
