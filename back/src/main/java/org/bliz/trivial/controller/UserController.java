package org.bliz.trivial.controller;

import org.bliz.trivial.controller.model.User;
import org.bliz.trivial.service.UserService;
import org.bliz.trivial.service.dto.UserDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return mapper.map(userService.login(mapper.map(user, UserDTO.class)), User.class); // Model -> DTO -> Model -> Pal front
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return mapper.map(userService.register(mapper.map(user, UserDTO.class)), User.class);
	}

}
