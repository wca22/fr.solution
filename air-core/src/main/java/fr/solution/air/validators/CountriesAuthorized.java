package fr.solution.air.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CountriesAuthorizedValidator.class)
public @interface CountriesAuthorized {

	String[] countries();

	String message() default "You are not allowed to register.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}