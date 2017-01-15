package com.crossover.project.application.interfaces;

import java.util.List;

import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.User;

public interface IQuestionApplication {

	void answer(Answer answer, User user);

	Question loadNext(User user);

	Question getByNumber(Integer number);

	Question getById(Integer id);

	List<Question> getAnsweredQuestions(User user);

	List<Answer> getAnswers(User user);
}
