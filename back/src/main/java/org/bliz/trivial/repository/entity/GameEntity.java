package org.bliz.trivial.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="games")
public class GameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	@Column(name="game_code")
	private Integer gameCode;

	@Column(name="current_user")
	private Integer currentUser;

	@ManyToOne
	@JoinColumn(name="cod_winner")
	private UserEntity user1;

	@ManyToOne
	@JoinColumn(name="cod_loser")
	private UserEntity user2;

	@ManyToOne
	@JoinColumn(name="cod_user_1")
	private UserEntity user3;

	@ManyToOne
	@JoinColumn(name="cod_user_2")
	private UserEntity user4;

	@OneToMany(mappedBy="game")
	private List<QuestionsPerGameEntity> questionsPerGames;

}