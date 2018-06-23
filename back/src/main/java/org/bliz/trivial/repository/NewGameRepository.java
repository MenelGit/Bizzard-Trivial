package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface NewGameRepository extends CrudRepository<GameEntity, Integer> {

}
