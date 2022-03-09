package fr.solution.air.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fr.solution.air.validators.AgeValid;
import fr.solution.air.validators.CountriesAuthorized;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	@NotEmpty(message = "Username must not be empty")
	private String username;

	@AgeValid(message = "You have to be an adult")
	@NotNull
	private LocalDate birthdate;

	@CountriesAuthorized(countries = {"FRANCE",
			"FRENCH"}, message = "You have to be in FRENCH OR FRANCE")
	private String country;

	private String phoneNumber;

	private String gender;

}