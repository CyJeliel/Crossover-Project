package com.crossover.project.repository.mapper.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;
import com.crossover.project.repository.mapper.implementations.entities.QuestionEntity;

@Mapper
public interface IQuestionMap extends IMapper<QuestionEntity, Question> {

	public static final IQuestionMap INSTANCE = Mappers.getMapper(IQuestionMap.class);

	Question entityToDomain(QuestionEntity questionEntity);

	QuestionEntity domainToEntity(Question question);

	Answer entityToDomain(AnswerEntity answer);
	
	AnswerEntity domainToEntity(Answer answer);
}
