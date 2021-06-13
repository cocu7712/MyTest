package com.db.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.dto.MemSignUpDTO;
import com.db.selfIntro.SelfIntroDto;
import com.db.selfIntro.SelfIntroVo;

@Controller
public class SelfIntroController {
	
	private SelfIntroVo selfIntroVo;

	//생성자에 service 주입
	public SelfIntroController(SelfIntroVo selfIntroVo) {
		this.selfIntroVo = selfIntroVo;
	}
	
	//리스트
	@RequestMapping("/myPage/selfIntroList")
	public String selfIntroList(Model model,HttpSession session,HttpServletRequest request) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		//자소서 리스트
		List<SelfIntroDto> selfIntrolist = selfIntroVo.selectAllSelfIntro(mEmail);
		
		model.addAttribute("selfIntrolist", selfIntrolist);
		return "myPage/selfIntroList";
	}
	
	//글목록
	@RequestMapping("/myPage/selfIntro")
	public String selfIntroMain(Model model,HttpSession session,HttpServletRequest request){
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		//자소서 리스트
		List<SelfIntroDto> selfIntrolist = selfIntroVo.selectAllSelfIntro(mEmail);
		//자소서 내용
		SelfIntroDto selfIntroDto = selfIntroVo.selectSelfIntro(request, mEmail);
		
		
		model.addAttribute("selfIntrolist", selfIntrolist);
		model.addAttribute("selfIntroDto", selfIntroDto);
		
		return "myPage/selfIntro";
	}
	
	//작성창
	@GetMapping("/myPage/selfIntroInsert")
	public String getSelfIntroInsert(Model model,HttpServletRequest request,HttpSession session){
MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		return "myPage/selfIntroInsert";
	}
	
	//작성한 데이터 처리
	@PostMapping("/myPage/selfIntroInsert")
	public String postSelfIntroInsert(Model model,HttpServletRequest request,HttpSession session){
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		//자소서 등록
		int result = selfIntroVo.selfIntroInsert(request,mEmail);
		
		//자소서 리스트
		List<SelfIntroDto> selfIntrolist = selfIntroVo.selectAllSelfIntro(mEmail);
		
		model.addAttribute("selfIntrolist", selfIntrolist);
		
		return "/myPage/selfIntroList";
	}
	
	//수정창
	@GetMapping("/myPage/selfIntroUpdate")
	public String getSelfIntroUpdate(Model model,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		//자소서 내용
		SelfIntroDto selfIntroDto = selfIntroVo.selectSelfIntro(request, mEmail);
		
		model.addAttribute("selfIntroDto", selfIntroDto);
		return "myPage/selfIntroUpdate";
	}
	
	//수정 데이터 처리
	@PostMapping("/myPage/selfIntroUpdate")
	public String postSelfIntroUpdate(Model model,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		//업데이트
		selfIntroVo.selfIntroUpdate(request, mEmail);
		
		return "redirect:/myPage/selfIntroList";
	}
	
	@PostMapping("/myPage/selfIntroDelete")
	public String selfIntroDelete(Model model,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		
		if(dto == null) {
			return "login";
		}
		
		String mEmail = dto.getMem_useremail();
		
		selfIntroVo.selfIntroDelete(request, mEmail);
		
		return "redirect:/myPage/selfIntroList";	
	}
		
		
}
