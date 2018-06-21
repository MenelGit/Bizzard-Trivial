package org.bliz.trivial.service;

import org.bliz.trivial.service.dto.UserDTO;

public interface UserService {

	UserDTO login(UserDTO user);

	UserDTO register(UserDTO user);
}
