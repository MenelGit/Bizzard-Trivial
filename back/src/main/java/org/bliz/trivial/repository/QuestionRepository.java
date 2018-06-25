package org.bliz.trivial.repository;

import java.util.List;

import org.bliz.trivial.repository.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer>  {

	List<QuestionEntity> findByQuestionsPerGamesIsCorrectAndQuestionsPerGamesGameGameCode(Integer isCorrect, Integer gameCode);//Game / GameCode

	@Override
	List<QuestionEntity> findAll();

	List<QuestionEntity> findByCategoryCodBlizzardGameNotIn(List<Integer> categories);
}
