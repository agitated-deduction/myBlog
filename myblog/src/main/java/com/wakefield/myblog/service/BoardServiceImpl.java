package com.wakefield.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wakefield.myblog.dao.BoardDAO;
import com.wakefield.myblog.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardDAO dao;
	
	@Override
	public List<BoardVO>getBoardList()throws Exception{
		return dao.getBoardList();
	}
	@Transactional
	@Override
	public BoardVO viewPost(BoardVO vo) throws Exception{
		BoardVO res = dao.getPost(vo);
		//if(res != null)
			dao.updateHit(vo);
		//else 
		if (res == null)throw new RuntimeException("해당 게시물이 존재하지 않습니다.");
		return res;
	}
	@Override
	public int insertPost(BoardVO vo)throws Exception {
		return dao.insertPost(vo);
	}
	@Override
	public int updatePost(BoardVO vo)throws Exception {
		return dao.updatePost(vo);
	}
	@Override
	public int deletePost(BoardVO vo)throws Exception {
		return dao.deletePost(vo);
	}
	@Override
	public List<BoardVO> getPostList(String writer)throws Exception {
		return dao.getPostList(writer);
	}
}
