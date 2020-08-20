package com.wakefield.myblog.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wakefield.myblog.model.BoardVO;
import com.wakefield.myblog.service.BoardService;

@Controller
public class BoardController {
	@Inject
	private BoardService service;
	@Inject
	private BoardVO vo;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String getBoardList(Model model) {
		model.addAttribute("boardList", service.getBoardList());
		return "board/main";
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getPostList(Model model, @PathVariable("id")String writer) {
		model.addAttribute("postList", service.getPostList(writer));
		return "blog/main";
	}
	
	@RequestMapping(value = "/{id}/post", method = RequestMethod.GET)
	public String postForm(Model model, @PathVariable("id")String writer) {
		
		return "blog/writeForm";
	}
	@RequestMapping(value = "/{id}/post", method = RequestMethod.POST)
	public String insertPost(Model model, @PathVariable("id")String writer) {
		service.insertPost(vo);
		return "blog/writeForm";
	}
}
