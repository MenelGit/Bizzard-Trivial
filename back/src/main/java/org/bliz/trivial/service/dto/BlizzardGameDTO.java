package org.bliz.trivial.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BlizzardGameDTO implements Serializable {

	private static final long serialVersionUID = -5656309809847856955L;

	private Integer codBlizzardGame;

	private String name;
}
