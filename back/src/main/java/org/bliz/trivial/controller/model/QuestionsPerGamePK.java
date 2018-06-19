package org.bliz.trivial.controller.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class QuestionsPerGamePK implements Serializable {

	private static final long serialVersionUID = -4346754443111685999L;

	private Integer questionCode;

	private Integer gameCode;

	private Integer userCode;
}
