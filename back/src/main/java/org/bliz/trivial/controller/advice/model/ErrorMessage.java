package org.bliz.trivial.controller.advice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

	private String message;

	private List<String> errors;

}
