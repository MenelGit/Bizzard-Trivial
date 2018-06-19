package org.bliz.trivial.service;

import org.bliz.trivial.service.dto.QuestionDTO;

public interface NewQuestionService {

	QuestionDTO save(QuestionDTO question);
}
