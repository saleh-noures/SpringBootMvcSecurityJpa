package com.noures.SpringBootMvcSecurityJpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Department")
public class DepartmentNotFoundException extends RuntimeException {
	public DepartmentNotFoundException(Long deptId)
	{
		super("Could not find Department '" + deptId + "'.");
	}

}
