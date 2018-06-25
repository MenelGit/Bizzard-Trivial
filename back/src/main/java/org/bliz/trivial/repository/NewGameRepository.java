package org.bliz.trivial.repository;

import java.util.List;

import org.bliz.trivial.repository.entity.GameEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NewGameRepository extends CrudRepository<GameEntity, Integer> {

	GameEntity findByGameCode(Integer gameCode);

	@Query("select game from GameEntity game "
			+ "where (game.playerOne.userCode = (:userCode) OR "
			+ "game.playerTwo.userCode = (:userCode)) AND "
			+ "game.winnerUser IS NULL AND "
			+ "game.loserUser IS NULL")
	GameEntity findGamesWithoutWinner(@Param(value = "userCode") Integer userCode);

	@Query("select game, count(*) from GameEntity game "
			+ "group by winnerUser")
	List<Object[]> getRanking();
}
