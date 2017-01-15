package com.crossover.project.domain.entities;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.crossover.project.domain.interfaces.core.InterfaceDomain;

public class Question implements InterfaceDomain<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String description;

	private Integer number;

	private List<Answer> answers;

	private Answer chosenAnswer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Answer getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(Answer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Map<Integer, String> getAnswersMap() {

		return answers.stream().collect(Collectors.toMap(Answer::getId, Answer::getDescription));
	}
	
	@Override
	public String toString() {

		return description;
	}
}
