package br.com.bidu.aulapi.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.bidu.aulapi.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> 
	       ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(
				HttpStatus.NOT_FOUND.value(), 
				e.getMessage(), 
				System.currentTimeMillis()
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
