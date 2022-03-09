package fr.solution.air.validators;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountriesAuthorizedValidator
		implements
			ConstraintValidator<CountriesAuthorized, String> {

	private String[] countries;

	@Override
	public void initialize(CountriesAuthorized constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		countries = constraintAnnotation.countries();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Arrays.stream(countries)
				.anyMatch(country -> value.contains(country));
	}

}