package com.crossover.project.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.crossover.project.domain.interfaces.InterfaceDomain;

/**
 * 
 * @author Cindy
 *
 */
public class User implements InterfaceDomain<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String login;

	private String password;

	private String fullName;

	private String passwordConfirmation;

	private String newPassword;

	private List<Answer> answers;

	public void add(Answer answer) {

		if (this.answers == null) {

			answers = new ArrayList<>();
		}

		answers.add(answer);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
