package com.crossover.project.repository.implementations;

import org.springframework.stereotype.Service;

import com.crossover.project.domain.entities.User;
import com.crossover.project.repository.database.implementations.Repository;
import com.crossover.project.repository.interfaces.IUserRepository;
import com.crossover.project.repository.mapper.implementations.entities.UserEntity;
import com.crossover.project.repository.mapper.interfaces.IUserMap;

@Service
public class UserRepository extends Repository<UserEntity, User> implements IUserRepository {

	private static final long serialVersionUID = 1L;

	public UserRepository() {

		super(IUserMap.INSTANCE);
	}

}
