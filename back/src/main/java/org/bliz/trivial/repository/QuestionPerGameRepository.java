package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.QuestionsPerGameEntity;
import org.bliz.trivial.repository.entity.QuestionsPerGameEntityPK;
import org.springframework.data.repository.CrudRepository;

public interface QuestionPerGameRepository extends CrudRepository<QuestionsPerGameEntity, QuestionsPerGameEntityPK> {

}
