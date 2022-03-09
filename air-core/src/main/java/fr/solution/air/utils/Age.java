package fr.solution.air.utils;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Age {

	public static boolean checkMajority(LocalDate date) {
		long d = ChronoUnit.YEARS.between(date, ZonedDateTime.now());
		if (d > 18)
			return true;
		else
			return false;
	}

}