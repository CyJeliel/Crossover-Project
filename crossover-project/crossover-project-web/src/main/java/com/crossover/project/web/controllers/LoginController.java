package com.crossover.project.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.project.application.interfaces.ILoginApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.UserStatusEnum;

import lombok.Getter;

@Controller
@SessionScope
public class LoginController {

	@Autowired
	ILoginApplication application;

	@Getter
	private User user;

	@RequestMapping({ "", "/", "/home" })
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView();

		String description = "Description";

		mav.addObject("testDescription", description);

		return mav;
	}

	@RequestMapping("login")
	public ModelAndView login(User user) {

		ModelAndView mav = new ModelAndView();

		UserStatusEnum status = application.login(user);

		switch (status) {

		case NOT_LOGGED:

			mav.setViewName("home");

			mav.addObject("feedback", status.getFeedback());

			this.user = null;

			break;

		default:

			mav.setViewName("forward:/question");

			this.user = user;

			break;
		}

		return mav;
	}
}
