package org.bliz.trivial.controller.advice;

import org.bliz.trivial.controller.advice.model.ErrorMessage;
import org.bliz.trivial.exception.CustomTrivialException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice extends BaseRestControllerAdvice {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = CustomTrivialException.class)
	public ErrorMessage handleCustomTrivialException(CustomTrivialException e) {
		return createResponse(messageSource.getMessage(e.getMessage(), null, null), null);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ErrorMessage handleInternalServerError(Exception e) {
		return createResponse(messageSource.getMessage("Oh! Something went wrong! Please contact with Tychus", null, null), null);
	}
}
