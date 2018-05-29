package com.logos.mapper;

import com.logos.domain.EditRequestProduct;


public interface ProductMapper {
	
	public static EditRequestProduct productToEditRequest(com.logos.entity.Product product) {
		EditRequestProduct request = new EditRequestProduct();
		
		request.setNameGoods(product.getNameGoods());
		request.setBodyType(product.getBodyType());
		request.setDescription(product.getDescription());
		request.setUnit(product.getUnit());
		request.setAvailability(product.getAvailability());
		request.setPrice(product.getPrice());
		request.setId(product.getId());
		request.setProducer(product.getProducer());
		request.setImageUrl(product.getImageUrl());
		request.setBrand(product.getBrand());
		
		return request;
	}
	
	public static com.logos.entity.Product editReuqestToProduct(EditRequestProduct request) {
		com.logos.entity.Product product = new com.logos.entity.Product();
				
		product.setId(request.getId());
		product.setNameGoods(request.getNameGoods());
		product.setBodyType(request.getBodyType());
		product.setDescription(request.getDescription());
		product.setUnit(request.getUnit());
		product.setAvailability(request.getAvailability());
		product.setPrice(request.getPrice());
		product.setProducer(request.getProducer());		
		product.setBrand(request.getBrand());
		product.setImageUrl(request.getImageUrl());
		return product;
	}	
	

}
