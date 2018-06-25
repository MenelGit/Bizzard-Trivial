package org.bliz.trivial.service;

import org.bliz.trivial.service.dto.AnswerDTO;

public interface AnswerService {

	Integer check(AnswerDTO answerDTO, Integer gameCode, String userName);
}
