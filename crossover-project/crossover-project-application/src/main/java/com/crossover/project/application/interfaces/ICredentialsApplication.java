package com.crossover.project.application.interfaces;

import java.util.List;

import com.crossover.project.domain.entities.User;

public interface ICredentialsApplication {

	List<User> checkCredentials(User user);
}
