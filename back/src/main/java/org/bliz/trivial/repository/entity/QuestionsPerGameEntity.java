package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions_per_game")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsPerGameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionsPerGameEntityPK id;

	@Column(name = "is_correct", columnDefinition="BIT")
	private Integer isCorrect;

	@Column(name = "is_played", columnDefinition="BIT")
	private Integer isPlayed;

	@ManyToOne
	@JoinColumn(name = "game_code", insertable = false, updatable = false)
	private GameEntity game;

	@ManyToOne
	@JoinColumn(name = "question_code", insertable = false, updatable = false)
	private QuestionEntity question;

	@ManyToOne
	@JoinColumn(name = "user_code", insertable = false, updatable = false)
	private UserEntity user;

}