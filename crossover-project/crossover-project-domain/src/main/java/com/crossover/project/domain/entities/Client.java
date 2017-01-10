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

@Entity
@Table(name = "Client")
@NamedQueries({ @NamedQuery(name = "Client.listar", query = "SELECT cliente FROM Client cliente"),
		@NamedQuery(name = "Client.buscarPorDescricao", query = "SELECT cliente FROM Client cliente WHERE cliente.nome = :nome") })
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String enderecoDescricao;

	@Getter
	@Setter
	private String bairro;

	@Getter
	@Setter
	private String enderecoComplemento;

	@Getter
	@Setter
	private Integer cep;

	@Getter
	@Setter
	private String telefone;

	@Getter
	@Setter
	private String email;
}
