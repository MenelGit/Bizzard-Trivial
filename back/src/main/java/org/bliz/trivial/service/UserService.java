package org.bliz.trivial.service;

import java.util.List;

import org.bliz.trivial.controller.model.Ranking;
import org.bliz.trivial.service.dto.UserDTO;

public interface UserService {

	UserDTO login(UserDTO user);

	UserDTO register(UserDTO user);

	List<Ranking> getRanking();
}
