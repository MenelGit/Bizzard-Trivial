package org.bliz.trivial.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class BlizzardGameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_code")
	private Integer categoryCode;

	@Column(name="description")
	private String description;

}