package org.bliz.trivial.controller.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ranking implements Serializable {

	private static final long serialVersionUID = 6299600044602615623L;

	private User user;

	private Long count;
}
