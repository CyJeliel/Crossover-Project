package com.crossover.project.repository.mapper.implementations.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.crossover.project.repository.mapper.entities.core.InterfaceEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Answer")
@NamedQueries({
		@NamedQuery(name = "Answer.getAnswersByUser", query = "SELECT a FROM AnswerEntity a JOIN a.users u WHERE u.id = :userId") })
public class AnswerEntity implements InterfaceEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String description;

	@Getter
	@Setter
	private boolean correct;

	@ManyToOne
	@JoinColumn(name = "questionId")
	@Getter
	@Setter
	private QuestionEntity questionEntity;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "answers")
	@Getter
	@Setter
	private Set<UserEntity> users;

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
}
