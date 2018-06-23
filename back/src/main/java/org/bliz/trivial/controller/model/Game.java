package org.bliz.trivial.controller.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game implements Serializable {

	private static final long serialVersionUID = -941472632367634263L;

	private Integer gameCode;

	private Integer current_player;

	private User winnerUser;

	private User loserUser;

	private User playerOne;

	private User playerTwo;

	private List<QuestionsPerGame> questionsPerGames;
}
