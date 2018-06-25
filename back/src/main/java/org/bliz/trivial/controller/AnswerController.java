package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.Answer;
import org.bliz.trivial.service.AnswerService;
import org.bliz.trivial.service.dto.AnswerDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/check")
	public Integer check(@RequestBody Answer answer, @RequestParam Integer gameCode, @RequestParam String userName) {
		return answerService.check(mapper.map(answer, AnswerDTO.class), gameCode, userName);
	}

}
