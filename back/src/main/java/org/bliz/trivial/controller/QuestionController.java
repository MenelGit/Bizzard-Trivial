package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.Question;
import org.bliz.trivial.service.QuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {
	@Autowired
	private QuestionService QuestionService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/getAll")
	public Question save(@RequestBody Question question) {
		return mapper.map(QuestionService.getAll()(mapper.map(question, QuestionDTO.class)), Question.class); // Model -> DTO -> Model -> Y pal front
	}
}
