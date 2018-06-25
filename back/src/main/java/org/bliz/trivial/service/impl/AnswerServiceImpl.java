package org.bliz.trivial.service.impl;

import org.bliz.trivial.repository.AnswerRepository;
import org.bliz.trivial.repository.NewGameRepository;
import org.bliz.trivial.repository.QuestionPerGameRepository;
import org.bliz.trivial.repository.UserRepository;
import org.bliz.trivial.repository.entity.AnswerEntity;
import org.bliz.trivial.repository.entity.GameEntity;
import org.bliz.trivial.repository.entity.QuestionsPerGameEntity;
import org.bliz.trivial.repository.entity.QuestionsPerGameEntityPK;
import org.bliz.trivial.service.AnswerService;
import org.bliz.trivial.service.dto.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionPerGameRepository questionGameRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NewGameRepository gameRepository;

	@Override
	public Integer check(AnswerDTO answerDTO, Integer gameCode, String userName) {
		Integer isCorrect = 0;
		AnswerEntity answerEntity = answerRepository.findByAnswerCode(answerDTO.getAnswerCode());
		if (answerEntity.getIsCorrect() == 1) {
			isCorrect = 1;
		} else {
			isCorrect = 0;
			GameEntity game = gameRepository.findByGameCode(gameCode);
			if (game.getPlayerOne().getUsername().equals(userName)) {
				game.setCurrent_player(game.getPlayerTwo().getUserCode());
			} else {
				game.setCurrent_player(game.getPlayerOne().getUserCode());
			}
			gameRepository.save(game);
		}
		QuestionsPerGameEntity qGame = new QuestionsPerGameEntity();
		QuestionsPerGameEntityPK qGamePK = new QuestionsPerGameEntityPK();
		qGamePK.setGameCode(gameCode);
		qGamePK.setQuestionCode(answerEntity.getQuestion().getQuestionCode());
		qGamePK.setUserCode(userRepository.findByUsername(userName).getUserCode());
		qGame.setId(qGamePK);
		qGame.setIsCorrect(isCorrect);
		qGame.setIsPlayed(1);
		questionGameRepository.save(qGame);
		return isCorrect;
	}
}
