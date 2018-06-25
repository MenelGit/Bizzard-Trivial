package org.bliz.trivial.service;

import org.bliz.trivial.service.dto.QuestionDTO;

public interface QuestionService {

	QuestionDTO save(QuestionDTO question);

	QuestionDTO findFirstQuestion(Integer userCode);

	QuestionDTO findNextQuestion(Integer gameCode, Integer userCode);
}
