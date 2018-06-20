package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BlizzardGameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_code")
	private Integer codBlizzardGame;

	@Column(name="description")
	private String description;

}