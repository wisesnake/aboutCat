package com.aboutcat.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboutcat.admin.member.dao.AdminMemberDAO;
import com.aboutcat.member.vo.MemberVO;


@Service
public class AdminMemberServiceImpl implements AdminMemberService{
	@Autowired
	AdminMemberDAO adminMemberDAO;



	@Override
	public ArrayList<MemberVO> listMember(HashMap<String, Object> condMap) {
		ArrayList<MemberVO> memberList = adminMemberDAO.searchMemberList(condMap);
		System.out.println(memberList);
		return memberList;
	}

}
