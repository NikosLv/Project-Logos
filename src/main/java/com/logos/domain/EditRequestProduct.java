package com.logos.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.logos.entity.Brand;
import com.logos.entity.enums.Availability;
import com.logos.entity.enums.BodyType;
import com.logos.entity.enums.Producer;
import com.logos.entity.enums.Unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditRequestProduct {
	
	private int id;
	
	@NotNull(message="Field nameGoods must be full")
	private String nameGoods;

	@NotEmpty (message="Field bodyType must be full")
	private BodyType bodyType;
	
	
	@NotEmpty (message="Field description must be full")
	private String description;
	
	@NotEmpty (message="Field unit must be full")
	private Unit unit;
	
	
	@NotEmpty (message="Field availability must be full")
	private Availability availability;
	
	
	@NotEmpty (message="Field producer must be full")
	private Producer producer;
	
	
	@NotEmpty (message="Field price must be full")
	private BigDecimal price;
	

	@NotEmpty (message="Field nameGoods must be full")
	private String imageUrl;

	@NotEmpty (message="Field nameGoods must be full")
	private Brand brand;
}
