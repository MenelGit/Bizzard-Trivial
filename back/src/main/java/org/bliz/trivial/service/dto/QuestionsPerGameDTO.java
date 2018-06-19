package org.bliz.trivial.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsPerGameDTO implements Serializable {

	private static final long serialVersionUID = -6680763609624970502L;

	private QuestionsPerGameDTOPK id;

	private Integer isCorrect;

	private Integer isPlayed;

	private GameDTO game;

	private QuestionDTO question;

	private UserDTO user;
}
