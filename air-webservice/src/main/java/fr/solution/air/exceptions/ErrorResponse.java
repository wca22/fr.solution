package fr.solution.air.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private List<String> details;

	private HttpStatus httpStatus;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	public ErrorResponse(HttpStatus httpStatus, String message,
			List<String> details) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.details = details;
	}
}