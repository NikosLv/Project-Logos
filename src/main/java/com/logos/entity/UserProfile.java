package com.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name = "user_profile", indexes = @Index(columnList = "first_name, last_name"))
@NoArgsConstructor
@Getter
@Setter
//@ToString(callSuper = true)
public class UserProfile extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private int age;

	@Column(name = "city")
	private String city;

	@Column(name = "phone_number")
	private String phoneNumber;

	//@OneToOne(mappedBy = "userProfile")
	//private User user;

}
