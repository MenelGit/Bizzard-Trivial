package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "tanswer")
@Data
public class AnswerEntity implements Serializable {

	private static final long serialVersionUID = -7482115211330566187L;

	@Id
	@Column(name = "cod_answer")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cod_question")
	private QuestionEntity question;

	@Column(name = "text")
	private String text;

	@Column(name = "correct")
	private Boolean isCorrect;
}
