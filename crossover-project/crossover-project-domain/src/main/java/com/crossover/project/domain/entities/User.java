package com.crossover.project.domain.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

/**
 * 
 * @author Cindy
 *
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String login;

	private String password;

	private String fullName;

	private String passwordConfirmation;

	private String newPassword;

	private Set<Answer> answers;

	public void add(Answer answer) {

		if (this.answers == null) {

			answers = new HashSet<>();
		}
		
		answers.add(answer);
	}
}
