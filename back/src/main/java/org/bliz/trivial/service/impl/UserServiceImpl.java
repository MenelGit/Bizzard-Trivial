package org.bliz.trivial.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.controller.model.Ranking;
import org.bliz.trivial.controller.model.User;
import org.bliz.trivial.exception.CustomTrivialException;
import org.bliz.trivial.repository.NewGameRepository;
import org.bliz.trivial.repository.UserRepository;
import org.bliz.trivial.repository.entity.GameEntity;
import org.bliz.trivial.repository.entity.UserEntity;
import org.bliz.trivial.service.UserService;
import org.bliz.trivial.service.dto.UserDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NewGameRepository gameRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public UserDTO login(UserDTO user) {
		UserEntity userFound = userRepository.findByUsername(user.getUsername());
		if (userFound != null) {
			if (userFound.getPassword().equals(user.getPassword())) {
				return mapper.map(userFound, UserDTO.class);
			} else {
				throw new CustomTrivialException("Invalid password");
			}
		} else {
			throw new CustomTrivialException("User not found");
		}
	}

	@Override
	public UserDTO register(UserDTO userToRegister) {
		UserEntity userFound = userRepository.findByUsername(userToRegister.getUsername());
		if (userFound == null) {
			return mapper.map(userRepository.save(mapper.map(userToRegister, UserEntity.class)), UserDTO.class); // DTO -> Entity. La base de datos le da un ID -> DTO -> Pal controller
		} else {
			throw new CustomTrivialException("User already exists");
		}
	}

	@Override
	public List<Ranking> getRanking() {
		Iterable<Object[]> games = gameRepository.getRanking();
		List<Ranking> rankings = new ArrayList<>();
		Ranking ranking;
		for (Object[] result : games) {
			ranking = new Ranking();
			GameEntity game = (GameEntity) result[0];
			Long count = (Long) result[1];
			UserDTO dto = mapper.map(game.getWinnerUser(), UserDTO.class);
			ranking.setUser(mapper.map(dto, User.class));
			ranking.setCount(count);
			rankings.add(ranking);

		}
		return rankings;
	}

}
