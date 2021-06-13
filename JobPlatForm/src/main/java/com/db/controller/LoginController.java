package com.db.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;
import com.db.service.LoginService;


@Controller
public class LoginController {
	private LoginService service;
	
	public LoginController(LoginService service) {
		this.service = service;
	}
	//로그인 페이지 접근
	@RequestMapping("/Login")
	public String Login() {
		return "/login";
	}
	
	@RequestMapping("/LoginOK")
	public String LoginOK(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		String email = request.getParameter("mem_email");
		String password = request.getParameter("mem_password");
		String kakao = request.getParameter("kakao_email");

		System.out.print("여기는 로그인");
		System.out.print("kakao :" + kakao);
		System.out.print("email :" + email);
		System.out.print("password :" + password);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		if(!kakao.equals("")) {
			System.out.print("여기는 카카오");
			MemSignUpDTO member = service.selectKakao(kakao);
			int count = service.countemail(kakao);
			if(count == 0) { // 회원가입창으로 이동
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter out = response.getWriter();
			    out.println("<script>alert('회원가입이 필요합니다.');window.location.href='/Sign_up';</script>");
			    out.flush();
			}else {
			session.setAttribute("member",member);
			}
		}else {
			System.out.print("여기는 일만멤버");
			MemSignUpDTO member = service.selectmember(map);
			if(member != null) { //1명
				System.out.print("인데 세션 생성");
				session.setAttribute("member",member);
				return "redirect:/main";
			}else {//0명
				System.out.print("인데 세션 생성 실패");
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter out = response.getWriter();
			    out.println("<script>alert('아이디 혹은 비밀번호가 맞지 않습니다.');window.history.back();</script>");
			    out.flush();
			}
		}
		return "redirect:/main";
	}
	
	@ResponseBody
	@RequestMapping("/SignLogin")
	public HashMap<String, String> Login(@RequestBody String mem_email, HttpSession session) {
		MemSignUpDTO member = service.selectKakao(mem_email);
		session.setAttribute("member",member);
		System.out.println(member);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", "200");
		return map;
	}
	
	
	@RequestMapping("/ComSignOK")
	public String ComSignOK(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
		String email = request.getParameter("com_email");
		String password = request.getParameter("com_password");
		System.out.println("email :" + email);
		System.out.println("password :" + password);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		
		System.out.print("여기는 컴퍼니");
		ComSignUpDTO company = service.selectcompany(map);
		if(company != null) { //1명
			System.out.print("인데 세션 생성");
			session.setAttribute("company",company);
			return "redirect:/main";
		}else {//0명
			System.out.print("인데 세션 생성 실패");
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
		    out.println("<script>alert('아이디 혹은 비밀번호가 맞지 않습니다.');window.history.back();</script>");
		    out.flush();
		}
		
		return "redirect:/main";
	}
	
	
	@RequestMapping("/logout")
	public String loguot(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
}
