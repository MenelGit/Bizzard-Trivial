package org.bliz.trivial.repository;

import java.util.List;

import org.bliz.trivial.repository.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface NewQuestionRepository extends CrudRepository<QuestionEntity, Integer>  {

	List<QuestionEntity> findByQuestionsPerGamesIsCorrectAndQuestionsPerGamesGame(Integer isCorrect, Integer gameCode);//Game / GameCode
}
