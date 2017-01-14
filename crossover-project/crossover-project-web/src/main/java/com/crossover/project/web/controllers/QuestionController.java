package com.crossover.project.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossover.project.application.interfaces.IQuestionApplication;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.User;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	LoginController loginController;

	@Autowired
	IQuestionApplication questionApplication;

	@Autowired
	@Qualifier("questionValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {

		User user = loginController.getUser();

		Question question = questionApplication.loadNext(user);

		String page = "question";
		if (question != null) {
			
			model.addAttribute("question", question);
			
		} else {
			
			page = "redirect:/testExam";
		}

		return page;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Valid Question question, BindingResult result) {

		String page = "question";

		if (result.hasErrors()) {

			model.addAttribute("question", question);

		} else {

			User user = loginController.getUser();

			questionApplication.answer(question.getChosenAnswer(), user);

			page = "redirect:/question";
		}

		return page;
	}
}
