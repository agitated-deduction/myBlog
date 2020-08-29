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
	public List<BoardVO> getPostList(String writer)throws Exception {
		return sqlSession.selectList(ns+"getPostList", writer);
	}

	@Override
	public BoardVO getPost(BoardVO vo)throws Exception {
		return sqlSession.selectOne(ns+"getPost", vo);
	}

	@Override
	public int insertPost(BoardVO vo)throws Exception {
		return sqlSession.insert(ns+"insertPost", vo);
	}

	@Override
	public int updatePost(BoardVO vo)throws Exception {
		return sqlSession.update(ns+"updatePost", vo);
	}

	@Override
	public int deletePost(BoardVO vo)throws Exception {
		return sqlSession.delete(ns+"deletePost", vo);
	}

	@Override
	public void updateHit(BoardVO vo)throws Exception {
		sqlSession.update(ns+"updateHit", vo);
		
	}

	@Override
	public List<BoardVO> getBoardList() throws Exception{
		return sqlSession.selectList(ns+"getBoardList");
	}

}
