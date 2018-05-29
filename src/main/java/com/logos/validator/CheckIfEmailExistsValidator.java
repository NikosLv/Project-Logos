package com.logos.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logos.repository.UserRepository;

@Component
public class CheckIfEmailExistsValidator implements ConstraintValidator<CheckIfEmailExists, String> {

	@Override
	public void initialize(CheckIfEmailExists constraintAnnotation) {
		}

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		if (email == null) return false;
		if(userRepository.findUserByEmail(email) != null) {
			return false;
		} else {
			return true;
		}
	}

}
