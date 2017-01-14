package com.crossover.project.repository.mapper.interfaces;

import org.junit.Test;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;

import junit.framework.TestCase;

public class AnswerMapperTest extends TestCase {

	@Test
	public void testShouldMapEntityToDomain() {
		// given
		AnswerEntity entity = new AnswerEntity();

		entity.setId(1);

		entity.setDescription("description");

		// when
		Answer answer = IAnswerMap.INSTANCE.entityToDomain(entity);

		// then
		assertNotNull(answer);
		assertEquals(Integer.valueOf(1), answer.getId());
		assertEquals("description", answer.getDescription());
	}

}
