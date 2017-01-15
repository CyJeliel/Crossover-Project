package com.crossover.project.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.crossover.project.domain.entities.TestExam;

@Component
public class TestExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return TestExam.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chosenQuestion", "valid.question");
	}

}
