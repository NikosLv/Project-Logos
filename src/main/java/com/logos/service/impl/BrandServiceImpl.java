package com.logos.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.logos.domain.SimpleFilter;
import com.logos.entity.Brand;
import com.logos.repository.BrandRepository;
import com.logos.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired private BrandRepository brandRepository;

	@Override
	public void saveBrand(Brand brand) {
		brandRepository.save(brand);
		
	}

	@Override
	public Brand findBrandId(int id) {
		return brandRepository.getOne(id);
	}

	@Override
	public List<Brand> findAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findBrandByMarkName(String markName) {
		return brandRepository.findBrandByMarkName(markName);
	}

	@Override
	public List<Brand> findAllBrandsByFilter(SimpleFilter filter) {
		return brandRepository.findAll(getSpecification(filter));
	}
	
	private Specification<Brand> getSpecification(SimpleFilter filter) {
		return new Specification<Brand>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getSearch().isEmpty()) return null;
				
				return cb.like(root.get("markName"), "%" + filter.getSearch() + "%");
			}
		
		};
	}

	@Override
	public Page<Brand> findBrandsByPage(Pageable pageable) {
		PageRequest pageRequest = 
				new PageRequest(
						pageable.getPageNumber(), 
						pageable.getPageSize(), 
						pageable.getSort());
		return brandRepository.findAll(pageRequest);
	}

}
