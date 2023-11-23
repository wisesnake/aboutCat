package com.aboutcat.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.aboutcat.member.vo.MemberVO;

public interface AdminMemberDAO {

	List<MemberVO> selectAllMembers();

	ArrayList<MemberVO> searchMemberList(HashMap<String, Object> condMap);

}
