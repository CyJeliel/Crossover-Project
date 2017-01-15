package com.crossover.project.domain.entities;

import com.crossover.project.domain.interfaces.core.InterfaceDomain;

public class Answer implements InterfaceDomain<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
