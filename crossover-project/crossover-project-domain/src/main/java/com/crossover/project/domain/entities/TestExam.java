package com.crossover.project.domain.entities;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.crossover.project.domain.interfaces.core.InterfaceDomain;

public class TestExam implements InterfaceDomain<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String description;

	private List<Question> questions;

	private Question chosenQuestion;

	private boolean finished;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getChosenQuestion() {
		return chosenQuestion;
	}

	public void setChosenQuestion(Question chosenQuestion) {
		this.chosenQuestion = chosenQuestion;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Integer, String> getQuestionsMap() {

		return questions.stream().collect(Collectors.toMap(Question::getId, Question::getDescription));
	}
}
