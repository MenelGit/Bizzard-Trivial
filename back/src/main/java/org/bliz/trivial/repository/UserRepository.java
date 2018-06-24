package org.bliz.trivial.repository;

import org.bliz.trivial.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username); // JPA Query Method. JPA entiende que Username es una propiedad de UserEntity y él solito te va a hacer la query correspondiente.	
}
