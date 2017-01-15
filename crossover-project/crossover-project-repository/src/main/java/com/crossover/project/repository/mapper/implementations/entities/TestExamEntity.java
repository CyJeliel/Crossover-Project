package com.crossover.project.repository.mapper.implementations.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crossover.project.repository.mapper.entities.core.InterfaceEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TestExam")
@NamedQueries({ @NamedQuery(name = "TestExam.get", query = "SELECT DISTINCT t FROM TestExamEntity t JOIN FETCH t.questions") })
public class TestExamEntity implements InterfaceEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String description;

	@Getter
	@Setter
	private boolean finished;

	@OneToMany(mappedBy = "testExamEntity", targetEntity = QuestionEntity.class, cascade = ALL)
	private List<QuestionEntity> questions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
