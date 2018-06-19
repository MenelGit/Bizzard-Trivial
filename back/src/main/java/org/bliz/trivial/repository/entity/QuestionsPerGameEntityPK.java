package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class QuestionsPerGameEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "question_code")
	private Integer questionCode;

	@Column(name = "game_code")
	private Integer gameCode;

	@Column(name = "user_code")
	private Integer userCode;

}