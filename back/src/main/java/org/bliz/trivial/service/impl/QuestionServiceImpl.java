package org.bliz.trivial.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.AnswerRepository;
import org.bliz.trivial.repository.NewGameRepository;
import org.bliz.trivial.repository.QuestionRepository;
import org.bliz.trivial.repository.UserRepository;
import org.bliz.trivial.repository.entity.AnswerEntity;
import org.bliz.trivial.repository.entity.GameEntity;
import org.bliz.trivial.repository.entity.QuestionEntity;
import org.bliz.trivial.service.QuestionService;
import org.bliz.trivial.service.dto.AnswerDTO;
import org.bliz.trivial.service.dto.QuestionDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private NewGameRepository gameRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public QuestionDTO save(QuestionDTO question) {
		try {
			QuestionEntity questionSaved = questionRepository.save(mapper.map(question, QuestionEntity.class));
			question.getAnswers().forEach(answer -> {
				AnswerEntity answerToSave = mapper.map(answer, AnswerEntity.class);
				answerToSave.setQuestion(questionSaved);
				answerRepository.save(answerToSave);
			});
			return mapper.map(questionSaved, QuestionDTO.class);
		} catch (Exception e) {
			throw new CustomTrivialException("Oh! What a disaster, tomatoe!");
		}
	}

	@Override
	public QuestionDTO findFirstQuestion(Integer userCode) {
		List<QuestionEntity> questionsList = questionRepository.findAll();
		return buildServiceResponse(questionsList, userCode, null);
	}

	@Override
	public QuestionDTO findNextQuestion(Integer gameCode, Integer userCode) {
		List<QuestionEntity> questionsAnsweredCorrectly = questionRepository.findByQuestionsPerGamesIsCorrectAndQuestionsPerGamesGameGameCode(1, gameCode);
		List<Integer> categories = new ArrayList<>();
		questionsAnsweredCorrectly.forEach(item -> {
			categories.add(item.getCategory().getCodBlizzardGame());
		});
		List<QuestionEntity> questionsNotAnswered = questionRepository.findByCategoryCodBlizzardGameNotIn(categories);
		return buildServiceResponse(questionsNotAnswered, userCode, gameRepository.findByGameCode(gameCode));
	}

	private QuestionDTO buildServiceResponse(List<QuestionEntity> questionsList, Integer userCode, GameEntity game) {
		if (!questionsList.isEmpty()) {
			QuestionEntity picked = questionsList.get((int) Math.round(Math.random() * (questionsList.size() - 1)));
			List<AnswerDTO> answersDTO = new ArrayList<>();
			picked.getAnswers().forEach(answer -> {
				answersDTO.add(mapper.map(answer, AnswerDTO.class));
			});
			QuestionDTO dto = mapper.map(picked, QuestionDTO.class);
			dto.setAnswers(answersDTO);
			return dto;
		} else {
			if (game != null) {
				if (game.getPlayerOne().getUserCode().equals(userCode)) {
					game.setWinnerUser(game.getPlayerOne());
					game.setLoserUser(game.getPlayerTwo());
				} else {
					game.setWinnerUser(game.getPlayerTwo());
					game.setLoserUser(game.getPlayerOne());
				}
				gameRepository.save(game);
			}
			throw new CustomTrivialException("No questions found.");
		}
	}

}
