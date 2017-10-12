package com.weatherapp.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.weatherapp.model.entities.User;


@Component
public class UserRegisterValidator implements Validator {

	final static String REG_EXP_EMAIL = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
	
	@Override
	public boolean supports(Class<?> testClass) {
		
		return User.class.equals(testClass);
	}

	@Override
	public void validate(Object object, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(err, "pass", "user.pass.empty");
		ValidationUtils.rejectIfEmpty(err, "country", "user.country.empty");
		ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(err, "date", "user.date.empty");
		User user = (User)object;
		
		Pattern pattern = Pattern.compile(REG_EXP_EMAIL, Pattern.CASE_INSENSITIVE);
		
		if (!(pattern.matcher(user.getEmail()).matches())) {
			
			err.rejectValue("email", "user.email.invalid");
		}
		
		
		
		
		
	}

}
