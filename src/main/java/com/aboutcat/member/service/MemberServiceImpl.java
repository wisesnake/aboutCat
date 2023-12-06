package com.aboutcat.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aboutcat.member.dao.MemberDAO;
import com.aboutcat.member.vo.MemberVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO login(Map loginMap) throws Exception {
		return memberDAO.login(loginMap);
	}

	@Override
	public void addMember(MemberVO memberVO) throws Exception{
		System.out.println("서비스에 맴버브이오"+memberVO);
		memberDAO.insertNewMember(memberVO);
	}
	
	@Override
	public String overlapped(String id) throws Exception{
		return memberDAO.selectOverlappedID(id);
	}

}
