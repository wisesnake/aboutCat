package com.aboutcat.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aboutcat.member.vo.MemberVO;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO{

	
	@Autowired
	SqlSession sqlSession;
	
	
	
	@Override
	public List<MemberVO> selectAllMembers() {
		List<MemberVO> membersList = sqlSession.selectList("mapper.admin.member.selectMembersListAll");
		return membersList;
	}



	@Override
	public ArrayList<MemberVO> searchMemberList(HashMap<String, Object> condMap) {
		ArrayList<MemberVO> membersList = (ArrayList)sqlSession.selectList("mapper.admin.member.searchMembersList", condMap);
		System.out.println(membersList);
		return membersList;
	}
	
	
}
