package com.crossover.project.domain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Cindy
 *
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({

		@NamedQuery(name = "User.verificarCredenciais", query = "SELECT usuario FROM User usuario WHERE usuario.login = :login AND usuario.senha = :senha"),
		@NamedQuery(name = "User.buscarPorLogin", query = "SELECT usuario FROM User usuario WHERE usuario.login = :login") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Getter
	@Setter
	private String login;

	@Getter
	@Setter
	private String senha;

	@Getter
	@Setter
	private String nome;

	@Setter
	@Getter
	private transient String confirmacaoSenha;

	@Setter
	@Getter
	private transient String novaSenha;
}
