package com.crossover.project.application.implementations;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.project.application.interfaces.IQuestionApplication;
import com.crossover.project.domain.entities.Answer;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.User;
import com.crossover.project.repository.interfaces.IAnswerRepository;
import com.crossover.project.repository.interfaces.IQuestionRepository;
import com.crossover.project.repository.interfaces.IUserRepository;

@Service
public class QuestionApplication implements IQuestionApplication {

	@Autowired
	IQuestionRepository repo;

	@Autowired
	IAnswerRepository answerRepo;

	@Autowired
	IUserRepository userRepo;

	@Override
	public Question loadNext(User user) {

		List<Question> answeredQuestions = getAnsweredQuestions(user);

		Integer nextQuestionNumber = 1;

		if (isNotEmpty(answeredQuestions)) {

			nextQuestionNumber = answeredQuestions.get(0).getNumber() + 1;
		}

		return getByNumber(nextQuestionNumber);
	}

	@Override
	public Question getByNumber(Integer number) {

		Question question = null;

		Map<String, Object> properties = new HashMap<>();

		properties.put("number", number);

		List<Question> questions = (List<Question>) repo.getMany("Question.getByNumber", properties);

		if (isNotEmpty(questions)) {

			question = questions.get(0);
		}

		return question;
	}

	@Override
	public List<Question> getAnsweredQuestions(User user) {

		Map<String, Object> properties = new HashMap<>();

		properties.put("userId", user.getId());

		return (List<Question>) repo.getMany("Question.getAnsweredByUser", properties);
	}

	@Override
	public List<Answer> getAnswers(User user) {

		Map<String, Object> properties = new HashMap<>();

		properties.put("userId", user.getId());

		return (List<Answer>) answerRepo.getMany("Answer.getAnswersByUser", properties);
	}

	@Override
	public void answer(Answer answer, User user) {

		userRepo.update(user, answer);
	}

}
