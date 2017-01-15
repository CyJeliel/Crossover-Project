package com.crossover.project.application.implementations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.project.application.interfaces.ITestExamApplication;
import com.crossover.project.domain.entities.TestExam;
import com.crossover.project.domain.interfaces.ITestExamRepository;

@Service
public class TestExamApplication implements ITestExamApplication {

	@Autowired
	ITestExamRepository repo;

	@Override
	public void finish(Integer id) {

		TestExam testExam = repo.getById(id);
		
		testExam.setFinished(true);
		
		repo.update(testExam);
	}

	@Override
	public TestExam get() {

		
		Map<String, Object> map = new HashMap<>();
		
		return repo.get("TestExam.get", map);
	}

}
