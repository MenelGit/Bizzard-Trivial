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

	private Integer currentUser;

	private UserDTO user1;

	private UserDTO user2;

	private UserDTO user3;

	private UserDTO user4;

	private List<QuestionsPerGameDTO> questionsPerGames;
}
