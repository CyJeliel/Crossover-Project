package com.crossover.project.repository.mapper.interfaces;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;
import com.crossover.project.repository.mapper.implementations.entities.QuestionEntity;

import junit.framework.TestCase;

public class QuestionMapperTest extends TestCase {

	@Test
	public void testShouldMapEntityToDomain() {
		// given
		QuestionEntity entity = new QuestionEntity();

		entity.setId(1);

		entity.setDescription("description");

		entity.setNumber(1);

		entity.setTitle("title");
		
		AnswerEntity answerEntity = new AnswerEntity();

		answerEntity.setId(1);

		answerEntity.setDescription("description");
		
		List<AnswerEntity> answers = Arrays.asList(answerEntity);
		
		entity.setAnswers(answers);

		// when
		Question q = IQuestionMap.INSTANCE.entityToDomain(entity);

		// then
		assertNotNull(q);
		assertEquals(Integer.valueOf(1), q.getId());
		assertEquals("description", q.getDescription());
		assertEquals(Integer.valueOf(1), q.getNumber());
		assertEquals("title", q.getTitle());
		assertNotNull(q.getAnswers());
		assertEquals(1, q.getAnswers().size());
		Answer answer = q.getAnswers().get(0);
		assertEquals(Integer.valueOf(1), answer.getId());
		assertEquals("description", answer.getDescription());

		
	}

}
