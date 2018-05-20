package com.logos.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.logos.entity.Brand;



@Component
public class BrandFormatter implements Formatter<Brand> {
	
	@Override
	public String print(Brand brand, Locale locale) {
		System.out.println("Print: " + brand.getId());
		return String.valueOf(brand.getId()+ ", "+ brand.getMarkName());
	}
		
	@Override
	public Brand parse(String objId, Locale arg1) throws ParseException {
		System.out.println("Parse: " + objId);
		objId.split(", ");
		int brandId= Integer.valueOf(objId.split(", ")[0]);
		
		Brand brand = new Brand();
		brand.setId(brandId);
		return brand;
	}
	

}
