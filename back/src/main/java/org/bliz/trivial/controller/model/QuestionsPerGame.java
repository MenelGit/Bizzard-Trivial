package org.bliz.trivial.controller.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsPerGame implements Serializable {

	private static final long serialVersionUID = -6680763609624970502L;

	private QuestionsPerGamePK id;

	private Integer isCorrect;

	private Integer isPlayed;

	private Game game;

	private Question question;

	private User user;
}
