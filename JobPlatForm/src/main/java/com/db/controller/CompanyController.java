package com.db.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.company.CompanyDto;
import com.db.company.CompanyService;
import com.db.dto.ComSignUpDTO;
import com.db.recruit.RecruitDto;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@RequestMapping("/company")
	public String test(){
		
		return "company/recruitRegist";
	}
	
	@RequestMapping("/recruitRegist")
	public String companyRegist(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		int no = service.getSequence();
		
		ComSignUpDTO companyDto = (ComSignUpDTO)session.getAttribute("company");
		
		String comName = companyDto.getCom_name(); 
		String category = request.getParameter("category");
		String title = request.getParameter("recruitTitle");
		String career = request.getParameter("career");
		String[] cbTag = request.getParameterValues("cbTag");
		String text1 = request.getParameter("Text1");
		String text2 = request.getParameter("Text2");
		String text3 = request.getParameter("Text3");
		String text4 = request.getParameter("Text4");
		String text5 = request.getParameter("Text5");
		
		RecruitDto dto = new RecruitDto(no, comName, category, title, career, text1, text2, text3, text4, text5);
		System.out.println(dto.getCareer());
		service.companyRegist(dto);
		
		for(int i = 0; i < cbTag.length; i++) {
			service.insertTagByNo(no, cbTag[i]);
		}
		return "redirect:/main";
	}
	
	@RequestMapping("/company/recruitEdit")
	public String test1(){
		
		return "company/recruitEdit";
	}
	
	@RequestMapping("/company/recruitList")
	public String test2(){
		
		return "company/recruitList";
	}
}
