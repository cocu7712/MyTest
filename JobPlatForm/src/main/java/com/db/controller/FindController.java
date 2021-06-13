package com.db.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.service.FindService;

@Controller
public class FindController {
	
	private FindService service;
	
	public FindController(FindService service) {
		this.service = service;
	}
	

	@RequestMapping("/findId")
	public String findId() {
		return "/findId";
	}
	
	@RequestMapping("/findPw")
	public String findPw() {
		return "/findPw";
	}
	@ResponseBody
	@RequestMapping("/userEmailSearch")
	public HashMap<String, String> userEmailSearch(@RequestBody HashMap<String, String> EmailFind) {
		System.out.println(EmailFind.get("mem_username"));
		int count = service.selectSearch(EmailFind);
		System.out.print("우선 countn 쿼리문 ㅇㅋ" + count);
		if(count == 0) {
			System.out.print("회원정보를 확인해주세요");
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("mem_userEmail", "회원 정보를 확인해주세요!");
			return map;
		}else if(count == 1) {
			System.out.print("흠");
			String mem_userEmail = service.FindUserEmail(EmailFind);
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("mem_userEmail", mem_userEmail);
			return map;
		}
		return null;
	}
	/*
	@RequestMapping("/userPwSearch")
	public String userPwSearch(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("mem_username");
		String email = request.getParameter("mem_email");
		//임시 비밀번호 생성
				String pw = "";
				for(int i=0;i<10;i++) {
					pw += (char)((Math.random()*26)+97);//랜덤 소문자
					//A부터 Z까지의 문자의 수는 26개, 
					//아스키코드로  65 ~ 90 까지가 영문대문자, 97~122 까지가 영문소문자
				}	
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
		    out.println("<script>alert('"+ msg +"');window.history.back();</script>");
		    return null;				
	}*/
	
	
}
