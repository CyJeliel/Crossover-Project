package com.crossover.project.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossover.project.application.interfaces.IQuestionApplication;
import com.crossover.project.application.interfaces.ITestExamApplication;
import com.crossover.project.domain.entities.Question;
import com.crossover.project.domain.entities.TestExam;

@Controller
@RequestMapping("/testExam")
public class TestExamController {

	@Autowired
	ITestExamApplication testExamApplication;

	@Autowired
	IQuestionApplication questionApplication;

	@Autowired
	@Qualifier("testExamValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String endTest(Model model) {

		TestExam testExam = testExamApplication.get();

		model.addAttribute("testExam", testExam);

		return "endTest";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(TestExam  testExam) {

		testExamApplication.finish(testExam.getId());

		return "redirect:/login";
	}

	@RequestMapping("/reviewQuestion")
	public String submitForm(Model model, @Valid TestExam testExam) {

		Question question = questionApplication.getById(testExam.getChosenQuestion().getId());

		model.addAttribute("question", question);

		return "question";
	}

}
