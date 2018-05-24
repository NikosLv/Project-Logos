package com.logos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.logos.entity.enums.Packing;
import com.logos.entity.enums.Payment;
import com.logos.entity.enums.Shipping;
import com.logos.entity.enums.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="sale")
@Getter @Setter
@NoArgsConstructor
public class Order extends BaseEntity {
	

	@Enumerated(EnumType.STRING)
	private Payment payment;
		
	@Enumerated(EnumType.STRING)
	private Shipping shipping;
	
	@Enumerated(EnumType.STRING)
	private Packing packing;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Size(min=5, max=70)
	@NotEmpty(message = "Field fullName can't be Empty")
	@Column(length = 500)
	private String address;
	

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

}
