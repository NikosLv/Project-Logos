package com.logos.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.entity.Product;
import com.logos.repository.ProductRepository;
import com.logos.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(int id) {
		return productRepository.getOne(id);
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
		
	}

	


}
