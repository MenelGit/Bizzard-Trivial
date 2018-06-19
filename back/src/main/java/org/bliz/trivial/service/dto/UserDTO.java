package org.bliz.trivial.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -7682872652603550050L;

	private Integer userCode;

	private String password;

	private String username;

	private List<QuestionsPerGameDTO> questionsPerGames;
}
