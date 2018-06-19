package org.bliz.trivial.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO implements Serializable {

	private static final long serialVersionUID = -7987994210781690946L;

	private Integer answerCode;

	private Integer isCorrect;

	private String text;

	private QuestionDTO question;
}
