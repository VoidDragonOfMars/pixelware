package com.weatherapp.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.weatherapp.model.entities.Report;
@Component
public class ReportFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> testClass) {
		
		return Report.class.equals(testClass);
	}

	@Override
	public void validate(Object object, Errors err) {
		
		ValidationUtils.rejectIfEmpty(err, "city", "report.city.empty");
	}

}
