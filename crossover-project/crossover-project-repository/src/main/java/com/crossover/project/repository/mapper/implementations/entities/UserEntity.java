package com.crossover.project.repository.mapper.implementations.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.crossover.project.repository.mapper.entities.core.InterfaceEntity;

import lombok.Data;

/**
 * 
 * @author Cindy
 *
 */
@Entity
@Table(name = "User")
@NamedQueries({

		@NamedQuery(name = "User.checkCredentials", query = "SELECT user FROM UserEntity user WHERE user.login = :login AND user.password = :password"),
		@NamedQuery(name = "User.searchForLogin", query = "SELECT user FROM UserEntity user WHERE user.login = :login") })
@Data
public class UserEntity implements InterfaceEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String login;

	private String password;

	private String fullName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_answers", joinColumns = @JoinColumn(name = "userId") , inverseJoinColumns = @JoinColumn(name = "answerId") )
	private Set<AnswerEntity> answers;
}
