package com.crossover.project.application;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.StatusCredencialEnum;

@Stateless
public class NovoUsuarioApplication implements IUsuarioApplication {

	@PersistenceContext(unitName = "br.com.arquiteturareferencia")
	private EntityManager em;

	public StatusCredencialEnum registrar(User usuario) {

		em.persist(usuario);

		return StatusCredencialEnum.VALIDO;
	}

}
