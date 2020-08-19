package com.wakefield.myblog.service;

import java.util.List;

import com.wakefield.myblog.model.BoardVO;

public interface BoardService {
	public List<BoardVO>getPostList(String writer);
	public List<BoardVO>getBoardList();
	public BoardVO viewPost(BoardVO vo);
	public int insertPost(BoardVO vo);
	public int updatePost(BoardVO vo);
	public int deletePost(BoardVO vo);
}
