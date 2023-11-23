package com.aboutcat.admin.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aboutcat.admin.member.service.AdminMemberService;
import com.aboutcat.common.base.BaseController;
import com.aboutcat.member.vo.MemberVO;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberControllerImpl extends BaseController implements AdminMemberController {
	@Autowired
	AdminMemberService adminMemberService;

	@Override
	@RequestMapping(value = "/adminMemberMain.do")
	public String adminMemberMain(@RequestParam Map<String, String> dateMap, HttpServletRequest request,
			HttpServletResponse response, Model model) {
//		HttpSession session = request.getSession();
//		String uid = (String) session.getAttribute("user_id");
//		if (!uid.equals("admin")) {
//			request.setAttribute("alert_notAdmin", "관리자 권한이 없습니다.");
//			// 메인페이지 header에서 alert_notAdmin이 null이 아닌경우 해당 페이지 alert으로 뜨게끔 코딩하는걸 가정하고 짠 코드.
//			return "main/main.do";
//		}

//		session.setAttribute("menu_mode", "admin_mode");
		String section = dateMap.get("section");
		String pageNum = dateMap.get("pageNum");
		//쿼리에서 페이징에 맞게 쿼리결과 뽑아오기 위해 넘길 값

		String searchPeriod = dateMap.get("searchPeriod");
		String beginDate = null, endDate = null;

		String tempDate[] = calcSearchPeriod(searchPeriod).split(",");
		beginDate = tempDate[0];
		endDate = tempDate[1];
		
		dateMap.put("beginDate",beginDate);
		dateMap.put("endDate",endDate);
		
		HashMap<String,Object> condMap = new HashMap<String,Object>();
		
		if(section == null) {
			section = "1";
		}
		condMap.put("section", section);
		
		if(pageNum == null) {
			pageNum = "1";
		}
		condMap.put("pageNum", pageNum);
		//최초요청시 = 클라이언트에서 1페이지를 봄
		
		condMap.put("beginDate", beginDate);
		condMap.put("endDate", endDate);
		
		ArrayList<MemberVO> membersList = adminMemberService.listMember(condMap);
		
		System.out.println(membersList);
		
		
		model.addAttribute("membersList",membersList);
		
		
		
		return "/admin/member/adminMemberMain";
	}

}
