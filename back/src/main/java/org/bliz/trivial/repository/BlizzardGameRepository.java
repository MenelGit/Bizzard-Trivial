package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.BlizzardGameEntity;
import org.springframework.data.repository.CrudRepository;

public interface BlizzardGameRepository extends CrudRepository<BlizzardGameEntity, Integer> {

}
