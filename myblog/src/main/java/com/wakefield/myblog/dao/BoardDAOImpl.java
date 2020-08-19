package com.wakefield.myblog.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wakefield.myblog.model.BoardVO;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Inject private SqlSession sqlSession;
	private String ns = "com.wakefield.myblog.board.boardMapper.";
	
	@Override
	public List<BoardVO> getPostList(String writer) {
		return sqlSession.selectList(ns+"getPostList", writer);
	}

	@Override
	public BoardVO getPost(BoardVO vo) {
		return sqlSession.selectOne(ns+"getPost", vo);
	}

	@Override
	public int insertPost(BoardVO vo) {
		return sqlSession.insert(ns+"insertPost", vo);
	}

	@Override
	public int updatePost(BoardVO vo) {
		return sqlSession.update(ns+"updatePost", vo);
	}

	@Override
	public int deletePost(BoardVO vo) {
		return sqlSession.delete(ns+"deletePost", vo);
	}

	@Override
	public void updateHit(BoardVO vo) {
		sqlSession.update(ns+"updateHit", vo);
		
	}

	@Override
	public List<BoardVO> getBoardList() {
		return sqlSession.selectList(ns+"getBoardList");
	}

}
