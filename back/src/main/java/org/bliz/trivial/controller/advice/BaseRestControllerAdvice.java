package org.bliz.trivial.controller.advice;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.controller.advice.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class BaseRestControllerAdvice {

	@Autowired
	MessageSource messageSource;

	protected List<String> createErrors(BindingResult bindingResult) {
		List<String> errors = new ArrayList<>();

		for (ObjectError error : bindingResult.getAllErrors()) {
			errors.add(String.format("%s %s", ((FieldError) error).getField(), ((FieldError) error).getDefaultMessage()));
		}

		return errors;
	}

	protected ErrorMessage createResponse(String message, List<String> errors) {
		return new ErrorMessage(message, errors);
	}

}
