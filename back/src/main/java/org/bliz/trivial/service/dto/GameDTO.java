package org.bliz.trivial.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO implements Serializable {

	private static final long serialVersionUID = -941472632367634263L;

	private Integer gameCode;

	private Integer current_player;

	private UserDTO winnerUser;

	private UserDTO loserUser;

	private UserDTO playerOne;

	private UserDTO playerTwo;

	private List<QuestionsPerGameDTO> questionsPerGames;
}
