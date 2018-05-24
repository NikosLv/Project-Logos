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
import javax.validation.constraints.Size;

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
	
	@Size(min=5, max=30)
	@NotNull(message = "Field nameFoods can't be null")
//	@NotEmpty(message = "Field fullName can't be Empty")
	@Column(name="nameGoods", length=200)
	private String nameGoods;
	
	//@NotNull(message = "Field bodyType should be selected")
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
	
	//@NotNull(message = "Field description can't be null")
	//@NotEmpty(message = "Field fullName can't be Empty")
	//@Size(min=20, max=800)
	@Column(name="description", length=500)
	private String description;
	
	//@NotNull(message = "Field unit should be selected")
	@Enumerated(EnumType.STRING)
	private Unit unit;
	
	//@NotNull(message = "Field availability should be selected")
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	@Enumerated(EnumType.STRING)
	private Producer producer;
	
	@NotNull(message = "Field can't be null")
	@Column(name="price", columnDefinition="DECIMAL(6,2)")
	private BigDecimal price;

	@Column(name = "image_url")
	private String imageUrl;
	

	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@Column(name = "date_download")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDownload = new Date();
			
	@OneToMany(mappedBy="product")
	private List<Order> orders = new ArrayList<>();
	
	
}
