package com.crossover.project.application.interfaces;

import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.CredentialsStatusEnum;

public interface IUserApplication {

	CredentialsStatusEnum register(User user);
}
