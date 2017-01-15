package com.crossover.project.application.interfaces;

import com.crossover.project.domain.entities.TestExam;

public interface ITestExamApplication {

	void finish(Integer testExamId);

	TestExam get();
}
