package com.wakefield.myblog.dao;

import java.util.List;

import com.wakefield.myblog.model.BoardVO;
import com.wakefield.myblog.util.Search;

public interface BoardDAO {
	public List<BoardVO>getPostList(String writer)throws Exception;
	public List<BoardVO>getBoardList(Search search)throws Exception;
	public BoardVO getPost(BoardVO vo)throws Exception;
	public int insertPost(BoardVO vo)throws Exception;
	public int updatePost(BoardVO vo)throws Exception;
	public int deletePost(BoardVO vo)throws Exception;
	public void updateHit(BoardVO vo)throws Exception;
	public int getTotalCnt(Search search) throws Exception;
}
