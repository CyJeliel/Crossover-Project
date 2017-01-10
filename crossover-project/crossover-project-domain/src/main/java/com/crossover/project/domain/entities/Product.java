package com.crossover.project.domain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({ @NamedQuery(name = "Product.listar", query = "SELECT produto FROM Product produto"),
		@NamedQuery(name = "Product.buscarPorDescricao", query = "SELECT produto FROM Product produto WHERE produto.descricao = :descricao"),
		@NamedQuery(name = "Product.buscarPorCategoria", query = "SELECT produto FROM Product produto WHERE produto.category.id = :categoriaId") })
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Getter
	@Setter
	private BigDecimal preco;

	@Getter
	@Setter
	private int estoque;

	@Getter
	@Setter
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	@Getter
	@Setter
	private Category category;
}
