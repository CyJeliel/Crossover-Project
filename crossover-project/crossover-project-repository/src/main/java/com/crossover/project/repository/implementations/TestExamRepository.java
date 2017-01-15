package com.crossover.project.repository.implementations;

import org.springframework.stereotype.Service;

import com.crossover.project.domain.entities.TestExam;
import com.crossover.project.repository.database.implementations.Repository;
import com.crossover.project.repository.interfaces.ITestExamRepository;
import com.crossover.project.repository.mapper.implementations.entities.TestExamEntity;
import com.crossover.project.repository.mapper.interfaces.ITestExamMap;

@Service
public class TestExamRepository extends Repository<TestExamEntity, TestExam>implements ITestExamRepository {

	private static final long serialVersionUID = 1L;

	public TestExamRepository() {
		super(ITestExamMap.INSTANCE);
	}

}
