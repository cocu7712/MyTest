package com.db.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.dto.MemSignUpDTO;
import com.db.resume.ResumeVo;

@Controller
public class ResumeController {

	private ResumeVo resumeVo;

	//생성자에 service 주입
	public ResumeController(ResumeVo resumeVo) {
		this.resumeVo = resumeVo;
		
	}
	
	@RequestMapping("myPage/resume")
	public String resume(HttpSession session,Model model){
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		

		return "myPage/resume";
	}
	
}

