package org.bliz.trivial.repository.entity;

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

import lombok.Data;

@Entity
@Table(name = "tquestion")
@Data
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	@Column(name = "cod_question")
	private Integer codQuestion;

	@Column(name = "question_text")
	private String question;

	@OneToMany(mappedBy = "question")
	private List<AnswerEntity> answers;

	@Column(name = "correct")
	private Boolean isCorrect;

	@Column(name = "played")
	private Boolean isPlayed;

	@ManyToOne
	@JoinColumn(name = "cod_bliz")
	private BlizzardGameEntity game;

}
