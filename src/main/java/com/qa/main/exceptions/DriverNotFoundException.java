package com.qa.main.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Driver not found, try a different ID")
public class DriverNotFoundException extends NoSuchElementException{
	
	
}
