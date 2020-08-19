package com.wakefield.myblog.dao;

import java.util.List;

import com.wakefield.myblog.model.BoardVO;

public interface BoardDAO {
	public List<BoardVO>getPostList(String writer);
	public List<BoardVO>getBoardList();
	public BoardVO getPost(BoardVO vo);
	public int insertPost(BoardVO vo);
	public int updatePost(BoardVO vo);
	public int deletePost(BoardVO vo);
	public void updateHit(BoardVO vo);
}
