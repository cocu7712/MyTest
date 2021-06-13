package com.db.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.apply.ApplyDto;
import com.db.apply.ApplyService;
import com.db.dto.MemSignUpDTO;
import com.db.recruit.RecruitDto;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService service;
	
	public ApplyController(ApplyService service) {
		this.service = service;
	}

	@RequestMapping("/selectTitle")
	public String selectIntroTitle(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws IOException {
		MemSignUpDTO member = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = member.getMem_useremail();
		
		List<ApplyDto> dto = service.selectIntroTitle(mEmail);
		
		model.addAttribute("dto", dto);
		return "recruit/recruit_apply";
	}
	
	
	@RequestMapping("/apply")
	public void applyRecruit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		RecruitDto recruit = (RecruitDto)session.getAttribute("recruit");
		int no = recruit.getNo();
		
		int introNo = Integer.parseInt(request.getParameter("selfIntro"));
		service.applCompany(no, introNo);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
	    out.println("성공적으로 지원 되었습니다.");
	}
	
	@RequestMapping("/applyList")
	public String applyList(HttpSession session, Model model) {
		MemSignUpDTO member = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = member.getMem_useremail();

		List<ApplyDto> dto = service.selectByEmail(mEmail);
		model.addAttribute("dto", dto);
		return "myPage/applyList";
	}
	
//	@RequestMapping("/applyDetail/{introNo}")
//	public String applyDetailByIntroNo(@PathVariable int IntroNo) {
//		System.out.println(IntroNo);
//	}
}

