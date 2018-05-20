package com.logos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.logos.entity.enums.UserRole;
import com.logos.validator.CheckIfEmailExists;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user", indexes = @Index(columnList = "email"))
@NoArgsConstructor
@Getter @Setter

public class User extends BaseEntity {

	@CheckIfEmailExists
	@Column(name = "email", nullable = false, unique = true) 
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	private String token;
	
	@Column(name = "created_add")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAdd = new Date();
	
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile = new UserProfile();
	
	@OneToMany(mappedBy="user")
	private List<Brand> brands = new ArrayList<>();
	
	
	@OneToMany(mappedBy="user")
	private List<Order> orders = new ArrayList<>();
	
	
	
	
//	@ManyToMany
//	@JoinTable(name="user_order", joinColumns=@JoinColumn(name="user_id"),
//	inverseJoinColumns=@JoinColumn(name="order_id"))
//	private List <Order>orders =new ArrayList<>();
	
	
	
	
	
}
