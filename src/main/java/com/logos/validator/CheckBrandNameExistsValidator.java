package com.logos.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logos.repository.BrandRepository;


@Component
public class CheckBrandNameExistsValidator implements ConstraintValidator<CheckBrandNameExists, String> {

	@Autowired private BrandRepository brandRepository;
	
	@Override
	public void initialize(CheckBrandNameExists constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String markName, ConstraintValidatorContext context) {
		if (markName == null) return false;
		
		if (brandRepository.findBrandByMarkName(markName) != null) {
			return false;
		} else {
			return true;
		}
	}

}
