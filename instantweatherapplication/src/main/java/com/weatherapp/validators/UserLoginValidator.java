package com.weatherapp.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.weatherapp.model.entities.User;


@Component
public class UserLoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> testClass) {
		
		return User.class.equals(testClass);
	}

	@Override
	public void validate(Object object, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(err, "pass", "user.pass.empty");

		
		
		
		
		
	}

}
