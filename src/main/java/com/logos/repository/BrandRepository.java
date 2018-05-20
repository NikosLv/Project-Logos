package com.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logos.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {
	
	@Query("SELECT b FROM Brand b WHERE LOWER(b.markName) = :markName")
	Brand findBrandByMarkName(@Param("markName") String markName);

}
