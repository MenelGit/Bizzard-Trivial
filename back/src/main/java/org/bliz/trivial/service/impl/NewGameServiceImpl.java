package org.bliz.trivial.service.impl;

import org.bliz.trivial.controller.model.Game;
import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.NewGameRepository;
import org.bliz.trivial.repository.entity.GameEntity;
import org.bliz.trivial.service.NewGameService;
import org.bliz.trivial.service.dto.GameDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewGameServiceImpl implements NewGameService{

	@Autowired
	private NewGameRepository newGameRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public GameDTO save(GameDTO game, Integer userCode) {
		try {
			game.setCurrent_player(userCode);
			GameEntity gameSaved = newGameRepository.save(mapper.map(game, GameEntity.class));
			return mapper.map(gameSaved, GameDTO.class);
		} catch(Exception e) {
			throw new CustomTrivialException("Oh! What a disaster, tomatoe!");
		}
	}

	@Override
	public GameDTO checkGame(Integer userCode) {
// findByPlayerOneUserCodeOrPlayerTwoUserCodeAndWinnerUserIsNullAndLoserUserIsNull
		GameEntity game = newGameRepository.findGamesWithoutWinner(userCode);
		if (game != null) {
			return mapper.map(game, GameDTO.class);
		} else {
			return null;
		}
	}

}
