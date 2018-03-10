package com.noures.SpringBootMvcSecurityJpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Employee")
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(Long empId) {
		super("Could not find Employee '" + empId + "'.");
	}

}
