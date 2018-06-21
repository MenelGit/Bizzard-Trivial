package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.Question;
import org.bliz.trivial.service.NewQuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class NewQuestionController {

	@Autowired
	private NewQuestionService newQuestionService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/new-question")
	public Question save(@RequestBody Question question) {
		return mapper.map(newQuestionService.save(mapper.map(question, QuestionDTO.class)), Question.class); // Model -> DTO -> Model -> Y pal front
	}
}
