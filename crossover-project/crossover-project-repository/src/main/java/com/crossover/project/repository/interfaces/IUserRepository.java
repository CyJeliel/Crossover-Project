package com.crossover.project.repository.interfaces;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.User;
import com.crossover.project.repository.interfaces.core.IRepository;

public interface IUserRepository extends IRepository<User> {

	void update(User entityDomain, Answer answer);

}
