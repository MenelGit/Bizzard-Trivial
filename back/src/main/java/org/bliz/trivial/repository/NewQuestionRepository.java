package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface NewQuestionRepository extends CrudRepository<QuestionEntity, Integer>  {

}
