package org.bliz.trivial.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer questionCode;

	private String text;

	private List<AnswerDTO> answers;

	private BlizzardGameDTO category;

	private List<QuestionsPerGameDTO> questionsPerGames;

}