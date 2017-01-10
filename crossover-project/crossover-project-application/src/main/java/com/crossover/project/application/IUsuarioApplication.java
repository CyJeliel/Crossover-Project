package com.crossover.project.application;

import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.StatusCredencialEnum;

public interface IUsuarioApplication {

	StatusCredencialEnum registrar(User usuario);
}
