package com.wakefield.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wakefield.myblog.dao.BoardDAO;
import com.wakefield.myblog.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardDAO dao;
	
	@Override
	public List<BoardVO>getBoardList(){
		return dao.getBoardList();
	}
	@Override
	public BoardVO viewPost(BoardVO vo) {
		BoardVO res = dao.getPost(vo);
		if(res != null)
			dao.updateHit(vo);
		return res;
	}
	@Override
	public int insertPost(BoardVO vo) {
		return dao.insertPost(vo);
	}
	@Override
	public int updatePost(BoardVO vo) {
		return dao.updatePost(vo);
	}
	@Override
	public int deletePost(BoardVO vo) {
		return dao.deletePost(vo);
	}
	@Override
	public List<BoardVO> getPostList(String writer) {
		return dao.getPostList(writer);
	}
}