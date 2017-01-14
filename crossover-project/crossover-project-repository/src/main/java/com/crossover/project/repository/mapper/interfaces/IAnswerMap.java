package com.crossover.project.repository.mapper.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;

@Mapper
public interface IAnswerMap extends IMapper<AnswerEntity, Answer> {

	public static final IAnswerMap INSTANCE = Mappers.getMapper(IAnswerMap.class);

	AnswerEntity domainToEntity(Answer answer);

	Answer entityToDomain(AnswerEntity answerEntity);
}
