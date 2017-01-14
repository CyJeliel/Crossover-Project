package com.crossover.project.repository.mapper.implementations.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crossover.project.repository.mapper.entities.core.InterfaceEntity;

@Entity
@Table(name = "Question")
@NamedQueries({
		@NamedQuery(name = "Question.getAnsweredByUser", query = "SELECT a.questionEntity FROM UserEntity u JOIN u.answers a WHERE u.id = :userId GROUP BY a.questionEntity.id ORDER BY a.questionEntity.number DESC"),
		@NamedQuery(name = "Question.getByNumber", query = "SELECT DISTINCT q FROM QuestionEntity q JOIN FETCH q.answers WHERE q.number = :number") })
public class QuestionEntity implements InterfaceEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String title;

	private String description;

	private Integer number;

	@OneToMany(mappedBy = "questionEntity", targetEntity = AnswerEntity.class, cascade = ALL)
	private List<AnswerEntity> answers = new ArrayList<>();

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

	public List<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerEntity> answers) {
		this.answers = answers;
	}

}
