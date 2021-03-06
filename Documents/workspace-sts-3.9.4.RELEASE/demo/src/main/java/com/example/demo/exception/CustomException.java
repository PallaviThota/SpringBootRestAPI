package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.maincontroller.StringReverseController;

@ControllerAdvice(basePackageClasses = StringReverseController.class)
public class CustomException extends ResponseEntityExceptionHandler {	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorDetails> handleInvalidInputException(InvalidInputException ex) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	  

}
