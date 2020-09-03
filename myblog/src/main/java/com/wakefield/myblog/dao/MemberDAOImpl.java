package com.wakefield.myblog.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wakefield.myblog.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject private SqlSession sqlSession;
	private String ns = "com.wakefield.myblog.member.memberMapper.";
	
	@Override
	public MemberVO loginCheck(MemberVO vo) throws Exception {
		return sqlSession.selectOne(ns+"loginCheck", vo);
	}

	@Override
	public int insertMember(MemberVO vo) throws Exception {
		return sqlSession.insert(ns+"insertMember", vo);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return sqlSession.update(ns+"updateMember", vo);
	}

	@Override
	public int deleteMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(ns+"deleteMember", vo);
	}

}
