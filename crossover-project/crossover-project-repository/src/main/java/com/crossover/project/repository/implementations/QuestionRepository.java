package com.crossover.project.repository.implementations;

import org.springframework.stereotype.Service;

import com.crossover.project.domain.entities.Question;
import com.crossover.project.repository.database.implementations.Repository;
import com.crossover.project.repository.interfaces.IQuestionRepository;
import com.crossover.project.repository.mapper.implementations.entities.QuestionEntity;
import com.crossover.project.repository.mapper.interfaces.IQuestionMap;

@Service
public class QuestionRepository extends Repository<QuestionEntity, Question>implements IQuestionRepository {

	private static final long serialVersionUID = 1L;

	public QuestionRepository() {

		super(IQuestionMap.INSTANCE);
	}
}
