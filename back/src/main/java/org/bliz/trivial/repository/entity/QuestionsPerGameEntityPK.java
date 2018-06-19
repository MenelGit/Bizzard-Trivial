package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsPerGameEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "question_code")
	private Integer questionCode;

	@Column(name = "game_code")
	private Integer gameCode;

	@Column(name = "user_code")
	private Integer userCode;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameCode == null) ? 0 : gameCode.hashCode());
		result = prime * result + ((questionCode == null) ? 0 : questionCode.hashCode());
		result = prime * result + ((userCode == null) ? 0 : userCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		QuestionsPerGameEntityPK other = (QuestionsPerGameEntityPK) obj;
		if (gameCode == null) {
			if (other.gameCode != null) {
				return false;
			}
		} else if (!gameCode.equals(other.gameCode)) {
			return false;
		}
		if (questionCode == null) {
			if (other.questionCode != null) {
				return false;
			}
		} else if (!questionCode.equals(other.questionCode)) {
			return false;
		}
		if (userCode == null) {
			if (other.userCode != null) {
				return false;
			}
		} else if (!userCode.equals(other.userCode)) {
			return false;
		}
		return true;
	}


}