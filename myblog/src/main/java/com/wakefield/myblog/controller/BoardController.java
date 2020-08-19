package com.wakefield.myblog.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wakefield.myblog.service.BoardService;

@Controller
public class BoardController {
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String getBoardList(Model model) {
		model.addAttribute("boardList", service.getBoardList());
		return "board/main";
	}
}
