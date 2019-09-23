package com.innovecture.weatherapp.errorhandle;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.innovecture.weatherapp.exception.ValidationException;
import com.innovecture.weatherapp.exception.ZipcodeNotFoundException;

@RestControllerAdvice
@RestController
public class WeatherAppExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppExceptionHandler.class);
	@ExceptionHandler(ZipcodeNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public final ExceptionResponse handleZipCodeNotFoundException(ZipcodeNotFoundException ex,
			WebRequest request) {
		LOGGER.error("Stacktrace : ",ex);
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return exceptionResponse;
	}
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public final ExceptionResponse handleValidationException(ValidationException ex,
			WebRequest request) {
		LOGGER.error("Stacktrace : ",ex);
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return exceptionResponse;
	}
}
