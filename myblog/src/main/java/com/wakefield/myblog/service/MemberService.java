package com.wakefield.myblog.service;

import org.springframework.stereotype.Component;

import com.wakefield.myblog.model.MemberVO;

@Component
public interface MemberService {
	public MemberVO loginCheck(MemberVO vo)throws Exception;
	public int insertMember(MemberVO vo) throws Exception;
	public int updateMember(MemberVO vo) throws Exception;
	public int deleteMember(MemberVO vo) throws Exception;
}
