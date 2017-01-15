package com.crossover.project.repository.implementations;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.interfaces.IAnswerRepository;
import com.crossover.project.repository.database.implementations.Repository;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;
import com.crossover.project.repository.mapper.interfaces.IAnswerMap;

@org.springframework.stereotype.Repository
public class AnswerRepository extends Repository<AnswerEntity, Answer>implements IAnswerRepository {

	private static final long serialVersionUID = 1L;

	public AnswerRepository() {

		super(IAnswerMap.INSTANCE);
	}
}
