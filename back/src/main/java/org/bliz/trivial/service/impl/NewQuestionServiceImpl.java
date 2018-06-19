package org.bliz.trivial.service.impl;

import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.NewQuestionRepository;
import org.bliz.trivial.repository.entity.QuestionEntity;
import org.bliz.trivial.service.NewQuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NewQuestionServiceImpl implements NewQuestionService {

	@Autowired
	private NewQuestionRepository newQuestionRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public QuestionDTO save(QuestionDTO question) {
		try {
			return mapper.map(newQuestionRepository.save(mapper.map(question, QuestionEntity.class)), QuestionDTO.class);
		} catch(Exception e) {
			throw new CustomTrivialException("Ha ocurrido un error inesperado");
		}
	}

}
