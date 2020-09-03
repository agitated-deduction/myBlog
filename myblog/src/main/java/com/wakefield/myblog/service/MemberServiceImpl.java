package com.wakefield.myblog.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wakefield.myblog.dao.MemberDAO;
import com.wakefield.myblog.model.MemberVO;
import com.wakefield.myblog.util.SHA256;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject MemberDAO dao;
	
	@Override
	public MemberVO loginCheck(MemberVO vo) throws Exception {
		vo.setPwd(SHA256.encryptSHA256(vo.getPwd()));
		return dao.loginCheck(vo);
	}

	@Override
	public int insertMember(MemberVO vo) throws Exception {
		vo.setPwd(SHA256.encryptSHA256(vo.getPwd()));
		return dao.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		vo.setPwd(SHA256.encryptSHA256(vo.getPwd()));
		return dao.updateMember(vo);
	}

	@Override
	public int deleteMember(MemberVO vo) throws Exception {
		vo.setPwd(SHA256.encryptSHA256(vo.getPwd()));
		return dao.deleteMember(vo);
	}

}
