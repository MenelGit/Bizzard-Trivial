package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.Game;
import org.bliz.trivial.service.NewGameService;
import org.bliz.trivial.service.dto.GameDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class NewGameController {

	@Autowired
	private NewGameService newGameService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/new-game")
	public Game save(@RequestBody Game game) {
		return mapper.map(newGameService.save(mapper.map(game, GameDTO.class)), Game.class); // Model -> DTO -> Model -> Y pal front
	}
}
