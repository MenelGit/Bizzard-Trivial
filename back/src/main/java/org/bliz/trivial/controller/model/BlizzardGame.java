package org.bliz.trivial.controller.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BlizzardGame implements Serializable {

	private static final long serialVersionUID = -8844317070564963745L;

	private Integer codBlizzardGame;

	private String description;

}
