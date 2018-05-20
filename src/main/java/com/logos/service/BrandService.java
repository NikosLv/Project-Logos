package com.logos.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.logos.domain.SimpleFilter;
import com.logos.entity.Brand;


public interface BrandService {
	
	void saveBrand(Brand brand);
	
	Brand findBrandId(int id);
	
	List<Brand> findAllBrands();
	
	Brand findBrandByMarkName(String markName);
	
	List<Brand> findAllBrandsByFilter(SimpleFilter filter);
	
	Page<Brand> findBrandsByPage(Pageable pageable);

}
