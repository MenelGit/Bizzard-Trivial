package org.bliz.trivial.repository;

import java.util.List;

import org.bliz.trivial.repository.entity.QuestionEntity;
import org.bliz.trivial.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {

	List<QuestionEntity> findAll();
}