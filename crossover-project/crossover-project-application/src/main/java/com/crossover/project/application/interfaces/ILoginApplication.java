package com.crossover.project.application.interfaces;

import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.UserStatusEnum;

public interface ILoginApplication {

	UserStatusEnum login(User user);
}
