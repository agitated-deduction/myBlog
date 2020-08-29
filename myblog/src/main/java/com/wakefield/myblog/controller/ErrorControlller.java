package com.wakefield.myblog.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControlller {
	/*
	 * public String error404() {
	 * 
	 * return "error/error404"; }
	 * 
	 * public String error500() {
	 * 
	 * return "error/error500"; }
	 */
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Model model, Exception e) {
		model.addAttribute("exception", e);
		
		return "error/ex";
	}
}
