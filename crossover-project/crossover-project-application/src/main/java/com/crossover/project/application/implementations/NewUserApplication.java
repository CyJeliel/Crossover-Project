package com.crossover.project.application.implementations;

import org.springframework.stereotype.Service;

import com.crossover.project.application.interfaces.IUserApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.CredentialsStatusEnum;

@Service
public class NewUserApplication implements IUserApplication {

	public CredentialsStatusEnum register(User user) {

		return CredentialsStatusEnum.INVALIDO;
	}

}
