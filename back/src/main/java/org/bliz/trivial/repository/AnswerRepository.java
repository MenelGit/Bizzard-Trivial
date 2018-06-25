package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.AnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<AnswerEntity, Integer> {

	AnswerEntity findByAnswerCode(Integer answerCode);

}
