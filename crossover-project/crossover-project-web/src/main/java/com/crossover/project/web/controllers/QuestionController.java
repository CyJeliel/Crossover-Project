package com.crossover.project.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.project.application.interfaces.IQuestionApplication;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.User;

@Controller
public class QuestionController {

	@Autowired
	LoginController loginController;

	@Autowired
	IQuestionApplication questionApplication;

	@RequestMapping("/question")
	public ModelAndView loadNextQuestion() {

		ModelAndView mav = new ModelAndView();

		User user = loginController.getUser();
		
		Question question = questionApplication.loadNext(user);

		mav.addObject("question", question);

		return mav;
	}
}
