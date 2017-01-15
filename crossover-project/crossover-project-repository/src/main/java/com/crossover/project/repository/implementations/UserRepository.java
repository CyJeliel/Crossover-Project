package com.crossover.project.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.interfaces.IUserRepository;
import com.crossover.project.repository.database.implementations.Repository;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;
import com.crossover.project.repository.mapper.implementations.entities.UserEntity;
import com.crossover.project.repository.mapper.interfaces.IUserMap;

@org.springframework.stereotype.Repository
public class UserRepository extends Repository<UserEntity, User>implements IUserRepository {

	private static final long serialVersionUID = 1L;

	public UserRepository() {

		super(IUserMap.INSTANCE);
	}

	@Override
	public void update(User entityDomain, Answer answer) {

		EntityManager em = getEntityManager();

		em.getTransaction().begin();

		UserEntity userEntity = em.find(UserEntity.class, entityDomain.getId());

		AnswerEntity answerEntity = em.find(AnswerEntity.class, answer.getId());

		List<AnswerEntity> answers = userEntity.getAnswers();

		if (answers == null) {

			answers = new ArrayList<>();
		}

		answers.add(answerEntity);

		userEntity.setAnswers(answers);

		em.merge(userEntity);

		em.getTransaction().commit();

		em.close();
	}
}
