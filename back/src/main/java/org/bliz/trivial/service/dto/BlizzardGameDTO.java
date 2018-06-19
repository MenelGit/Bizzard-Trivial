package org.bliz.trivial.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlizzardGameDTO implements Serializable {

	private static final long serialVersionUID = -5656309809847856955L;

	private Integer codBlizzardGame;

	private String description;
}
