package com.logos.domain;

import java.math.BigDecimal;
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
	
	private String nameGoods;

	private BodyType bodyType;
	
	private String description;
				
	private Unit unit;
	
	private Availability availability;
		
	private Producer producer;
	
	private BigDecimal price;

	//private String imageUrl;

}
