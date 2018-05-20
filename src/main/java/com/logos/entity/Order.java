package com.logos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.logos.entity.enums.Packing;
import com.logos.entity.enums.Payment;
import com.logos.entity.enums.Shipping;

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
	
	@Column(name = "creat_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime = new Date();
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

}
