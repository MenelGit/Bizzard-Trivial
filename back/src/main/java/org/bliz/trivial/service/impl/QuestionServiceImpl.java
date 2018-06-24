package org.bliz.trivial.service.impl;

import java.util.List;

import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.QuestionRepository;
import org.bliz.trivial.repository.UserRepository;
import org.bliz.trivial.repository.entity.QuestionEntity;
import org.bliz.trivial.repository.entity.UserEntity;
import org.bliz.trivial.service.QuestionService;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.bliz.trivial.service.dto.UserDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public QuestionDTO getAll() {
		List<QuestionEntity> questionsList = questionRepository.findAll();
		if (questionsList != null) {
			QuestionEntity picked = questionsList.get((int) Math.round(Math.random() * (questionsList.size()))); 
				return mapper.map(picked, QuestionDTO.class);
			} else {
				throw new CustomTrivialException("No questions found.");
			}
	}
}
