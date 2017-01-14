package com.crossover.project.application.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.project.application.interfaces.ICredentialsApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.repository.interfaces.IUserRepository;

@Service
public class CredentialsApplication implements ICredentialsApplication {

	@Autowired
	private IUserRepository repo;

	@Override
	public List<User> checkCredentials(User User) {

		Map<String, Object> properties = new HashMap<>();

		properties.put("login", User.getLogin());

		properties.put("password", User.getPassword());

		return (List<User>) repo.getMany("User.checkCredentials", properties);
	}

}
