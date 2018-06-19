package org.bliz.trivial.controller;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.bliz.trivial.service.BlizzardGameService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class NewQuestionController {

	@Autowired
	private BlizzardGameService blizService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/new-question")
	public Question save() {
		return null;
	}
}
