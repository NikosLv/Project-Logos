package com.logos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.logos.validator.CheckBrandNameExists;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Table (name="brand")
@Getter @Setter
@NoArgsConstructor
public class Brand extends BaseEntity {
	
	//@Column(name="typeOfTransport", length=70)
	//private String typeOfTransport;
	
	@CheckBrandNameExists
	@NotNull(message = "Mark name can't be null")
	@NotEmpty(message = "Mark name can't be empty")
	@Column(name="mark_name", length=50)
	private String markName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="brand")
	private List<Product> products = new ArrayList<>();
	
	
	

}
