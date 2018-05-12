package org.bliz.trivial.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbliz")
@Data
public class BlizzardGameEntity {

	@Id
	@Column(name = "cod_bliz")
	private Integer codBlizzardGame;

	@Column(name = "name")
	private String name;

}
