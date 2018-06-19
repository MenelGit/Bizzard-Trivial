package org.bliz.trivial.controller.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer questionCode;

	private String text;

	private List<Answer> answers;

	private BlizzardGame category;

	private List<QuestionsPerGame> questionsPerGames;

}