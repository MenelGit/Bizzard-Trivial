package org.bliz.trivial.service.impl;

import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.AnswerRepository;
import org.bliz.trivial.repository.NewQuestionRepository;
import org.bliz.trivial.repository.entity.AnswerEntity;
import org.bliz.trivial.repository.entity.QuestionEntity;
import org.bliz.trivial.service.NewQuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewQuestionServiceImpl implements NewQuestionService {

	@Autowired
	private NewQuestionRepository newQuestionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public QuestionDTO save(QuestionDTO question) {
		try {
			QuestionEntity questionSaved = newQuestionRepository.save(mapper.map(question, QuestionEntity.class));
			question.getAnswers().forEach(answer -> {
				AnswerEntity answerToSave = mapper.map(answer, AnswerEntity.class);
				answerToSave.setQuestion(questionSaved);
				answerRepository.save(answerToSave);
			});
			return mapper.map(questionSaved, QuestionDTO.class);
		} catch(Exception e) {
			throw new CustomTrivialException("Oh! What a disaster, tomatoe!");
		}
	}

}
