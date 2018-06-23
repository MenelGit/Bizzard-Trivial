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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="games")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	@Column(name="game_code")
	private Integer gameCode;

	@Column(name="current_player")
	private Integer current_player;

	@ManyToOne
	@JoinColumn(name="cod_winner")
	private UserEntity winnerUser;

	@ManyToOne
	@JoinColumn(name="cod_loser")
	private UserEntity loserUser;

	@ManyToOne
	@JoinColumn(name="cod_user_1")
	private UserEntity playerOne;

	@ManyToOne
	@JoinColumn(name="cod_user_2")
	private UserEntity playerTwo;

	@OneToMany(mappedBy="game")
	private List<QuestionsPerGameEntity> questionsPerGames;

}