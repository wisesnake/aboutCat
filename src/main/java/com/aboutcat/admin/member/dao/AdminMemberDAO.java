package com.aboutcat.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.aboutcat.member.vo.MemberVO;

public interface AdminMemberDAO {

	public List<MemberVO> selectAllMembers();

	public ArrayList<MemberVO> searchMemberList(HashMap<String, Object> condMap);

	public MemberVO memberDetail(String member_id);

}
