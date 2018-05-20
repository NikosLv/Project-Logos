package com.logos.entity;

import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.logos.entity.enums.Availability;
import com.logos.entity.enums.BodyType;
import com.logos.entity.enums.Producer;
import com.logos.entity.enums.Unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name="product")
@Getter @Setter
@NoArgsConstructor
public class Product extends BaseEntity{
	
	@NotNull(message = "Field fullName can't be null")
	@NotEmpty(message = "Field fullName can't be Empty")
	@Column(name="nameGoods", length=200)
	private String nameGoods;
	
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
	
	@NotNull(message = "Field fullName can't be null")
	@NotEmpty(message = "Field fullName can't be Empty")
	@Column(length = 500)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Unit unit;
	
	@Enumerated(EnumType.STRING)
	private Availability availability;
		
	@Enumerated(EnumType.STRING)
	private Producer producer;
	
	@Column(name="price", columnDefinition="DECIMAL(6,2)")
	private BigDecimal price;

	@Column(name = "image_url")
	private String imageUrl;
	
	@NotNull(message = "Brand should be selected")
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@Column(name = "date_download")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDownload = new Date();
			
	@OneToMany(mappedBy="product")
	private List<Order> orders = new ArrayList<>();
	
	
}
