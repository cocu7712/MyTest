package com.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.recruit.RecruitDto;
import com.db.recruit.RecruitService;

@Controller
public class MainController {
	@Autowired
	private RecruitService service;
	
	public MainController(RecruitService service) {
		this.service = service;
	}
	
	@RequestMapping("/main")
	public String getMain(Model model){
		List<RecruitDto> dto = service.selectAllRecruit();
		model.addAttribute("recruit", dto);
		for(RecruitDto vo : dto) {
			System.out.println(vo.getNo());
		}
		System.out.println(dto.size());
		return "main/main";
	}
}
