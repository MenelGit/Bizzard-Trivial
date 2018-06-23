package org.bliz.trivial.controller;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.controller.model.BlizzardGame;
import org.bliz.trivial.controller.model.Game;
import org.bliz.trivial.service.BlizzardGameService;
import org.bliz.trivial.service.dto.BlizzardGameDTO;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class BlizzardGameController {

	@Autowired
	private BlizzardGameService blizService;

	@Autowired
	private Mapper mapper;

	@GetMapping("/categories")
	public List<BlizzardGame> getAll() {
		List<BlizzardGameDTO> gamesDTO = blizService.getAll();
		List<BlizzardGame> games = new ArrayList<>();
		gamesDTO.forEach(item -> {
			games.add(mapper.map(item, BlizzardGame.class));
		});
		return games;
	}
	
}
