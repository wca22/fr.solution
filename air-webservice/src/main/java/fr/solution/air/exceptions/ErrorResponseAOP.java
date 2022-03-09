package fr.solution.air.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponseAOP extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private List<String> details;

	private HttpStatus httpStatus;

	public ErrorResponseAOP(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	public ErrorResponseAOP(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
}