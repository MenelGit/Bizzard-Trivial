package org.bliz.trivial.service;

import org.bliz.trivial.service.dto.GameDTO;

public interface NewGameService {

	GameDTO save(GameDTO question, Integer userCode);

	GameDTO checkGame(Integer userCode);
}
