package com.crossover.project.repository.mapper.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.TestExam;
import com.crossover.project.repository.mapper.implementations.entities.AnswerEntity;
import com.crossover.project.repository.mapper.implementations.entities.QuestionEntity;
import com.crossover.project.repository.mapper.implementations.entities.TestExamEntity;

@Mapper
public interface ITestExamMap extends IMapper<TestExamEntity, TestExam> {

	public static final ITestExamMap INSTANCE = Mappers.getMapper(ITestExamMap.class);

	TestExam entityToDomain(TestExamEntity testExamEntity);

	TestExamEntity domainToEntity(TestExam testExam);

	Question entityToDomain(QuestionEntity questionEntity);

	QuestionEntity domainToEntity(Question question);

	Answer entityToDomain(AnswerEntity answer);
	
	AnswerEntity domainToEntity(Answer answer);

}
