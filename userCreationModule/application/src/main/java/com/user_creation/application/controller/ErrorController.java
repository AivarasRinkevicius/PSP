package com.user_creation.application.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex.getStackTrace());
		mv.addObject("message", ex.getMessage());
		mv.addObject("url", req.getRequestURL());
		mv.setViewName("error");
		return mv;
	}
}