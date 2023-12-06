package com.aboutcat.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aboutcat.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public MemberVO login(Map loginMap) throws DataAccessException {
		MemberVO member = (MemberVO) sqlSession.selectOne("mapper.member.login", loginMap);
		return member;
	}

	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException {
		System.out.println("디에이오에 맴버브이오" + memberVO);
		
		sqlSession.insert("mapper.member.insertNewMember", memberVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectOverlappedID", id);
		return result;
	}
	
	

}
