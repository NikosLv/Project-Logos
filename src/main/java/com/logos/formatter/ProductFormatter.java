package com.logos.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.logos.entity.Product;

@Component
public class ProductFormatter implements Formatter<Product> {

	@Override
	public String print(Product product, Locale locale) {
		System.out.println("Print: " + product.getId());
		return String.valueOf(product.getId()+ ", "+ product.getNameGoods());
	}

	@Override
	public Product parse(String objId, Locale arg1) throws ParseException {
		System.out.println("Parse: " + objId);
		objId.split(", ");
		int productId= Integer.valueOf(objId.split(", ")[0]);
		
		Product product = new Product();
		product.setId(productId);
		return product;
	}

}
