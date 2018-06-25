package org.bliz.trivial.controller;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.controller.model.Answer;
import org.bliz.trivial.controller.model.Question;
import org.bliz.trivial.service.QuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/new-question")
	public Question save(@RequestBody Question question) {
		return mapper.map(questionService.save(mapper.map(question, QuestionDTO.class)), Question.class); // Model -> DTO -> Model -> Y pal front
	}

	@GetMapping("/questions")
	public Question findFirstQuestion(@RequestParam Integer userCode) {
		QuestionDTO questionDTO = questionService.findFirstQuestion(userCode);
		return buildControllerResponse(questionDTO);
	}

	@GetMapping("/next-question")
	public Question findQuestion(@RequestParam Integer gameCode, @RequestParam Integer userCode) {
		QuestionDTO questionDTO = questionService.findNextQuestion(gameCode, userCode);
		return buildControllerResponse(questionDTO);
	}

	private Question buildControllerResponse(QuestionDTO questionDTO) {
		List<Answer> answers = new ArrayList<>();
		questionDTO.getAnswers().forEach(answer -> {
			answers.add(mapper.map(answer, Answer.class));
		});
		Question question = mapper.map(questionDTO, Question.class);
		question.setAnswers(answers);
		return question;
	}
}
