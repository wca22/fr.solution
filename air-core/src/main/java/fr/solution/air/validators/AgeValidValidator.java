package fr.solution.air.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.solution.air.utils.Age;

public class AgeValidValidator
		implements
			ConstraintValidator<AgeValid, LocalDate> {

	@Override
	public void initialize(AgeValid constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(LocalDate value,
			ConstraintValidatorContext context) {
		return Age.checkMajority(value);
	}

}
