package com.wakefield.myblog.service;

import java.util.List;

import com.wakefield.myblog.model.BoardVO;
import com.wakefield.myblog.util.Search;

public interface BoardService {
	public List<BoardVO>getPostList(String writer)throws Exception;
	public List<BoardVO>getBoardList(Search search)throws Exception;
	public BoardVO viewPost(BoardVO vo)throws Exception;
	public int insertPost(BoardVO vo)throws Exception;
	public int updatePost(BoardVO vo)throws Exception;
	public int deletePost(BoardVO vo)throws Exception;
	public int getTotalCnt(Search search) throws Exception;
}
