package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.Game;
import org.bliz.trivial.controller.model.User;
import org.bliz.trivial.service.NewGameService;
import org.bliz.trivial.service.dto.GameDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class NewGameController {

	@Autowired
	private NewGameService newGameService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/new-game")
	public Game save(@RequestBody Game game, @RequestParam Integer userCode) {
		return mapper.map(newGameService.save(mapper.map(game, GameDTO.class), userCode), Game.class); // Model -> DTO -> Model -> Y pal front
	}

	@GetMapping("/check-game")
	public Game checkGame(@RequestParam Integer userCode) {
		GameDTO game = newGameService.checkGame(userCode);
		if (game != null) {
			return mapper.map(game, Game.class);
		} else {
			return new Game(null, null, new User(null, null, null, null), new User(null, null, null, null), new User(null, null, null, null), new User(null, null, null, null), null);
		}
	}
}
