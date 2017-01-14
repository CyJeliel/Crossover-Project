package com.crossover.project.application.implementations;

import static com.crossover.project.domain.enumerations.UserStatusEnum.LOGGED;
import static com.crossover.project.domain.enumerations.UserStatusEnum.NOT_LOGGED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.project.application.interfaces.ICredentialsApplication;
import com.crossover.project.application.interfaces.ILoginApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.UserStatusEnum;

@Service
public class LoginApplication implements ILoginApplication {

	@Autowired
	private ICredentialsApplication credentialsApplication;

	@Override
	public UserStatusEnum login(User user) {

		UserStatusEnum status = NOT_LOGGED;

		List<User> users = credentialsApplication.checkCredentials(user);

		if (users != null && users.size() == 1) {

			User loggedUser = users.get(0);

			user.setFullName(loggedUser.getFullName());

			user.setId(loggedUser.getId());

			return LOGGED;
		}

		return status;
	}
}
