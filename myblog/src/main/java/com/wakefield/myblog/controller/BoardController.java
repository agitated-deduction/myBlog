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
	
	
	@RequestMapping(value = "/{bid}", method = RequestMethod.GET)
	public String getPostList(Model model, @PathVariable("bid")String writer) {
		model.addAttribute("postList", service.getPostList(writer));
		return "blog/main";
	}
	
	@RequestMapping(value = "/{uid}/post", method = RequestMethod.GET)
	public String postForm(Model model, @PathVariable("uid")String writer) {
		
		return "blog/writeForm";
	}
	@RequestMapping(value = "/{uid}/post", method = RequestMethod.POST)
	public String insertPost(Model model, @PathVariable("uid")String writer, BoardVO vo) {
		vo.setLock(false);//test용 임시
		service.insertPost(vo);
		return "redirect:/board";//임시
	}
	@RequestMapping(value = "/{uid}/post", method = RequestMethod.PUT)
	public String updatePost(Model model, @PathVariable("uid")String writer) {
		//수정 과정. 수정폼은 글쓰기 폼과 동일, 엥 그럼 게시물 번호는.
		//vo만들어
		service.updatePost(vo);
		return "";
	}
	@RequestMapping(value = "/{bid}/{num}", method = RequestMethod.GET)
	public String viewPost(Model model, @PathVariable("bid")String writer, @PathVariable("num")int idx) {
		vo.setIdx(idx);
		vo.setWriter(writer);
		model.addAttribute("post", service.viewPost(vo));
		return "blog/aPost";
	}
	@RequestMapping(value = "/{uid}/{num}", method = RequestMethod.DELETE)
	public String deletePost(Model model, @PathVariable("uid")String writer, @PathVariable("num")int idx) {
		vo.setIdx(idx);
		vo.setWriter(writer);
		service.deletePost(vo);
		return "";
	}
}
