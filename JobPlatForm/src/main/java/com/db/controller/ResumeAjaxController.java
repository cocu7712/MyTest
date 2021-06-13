package com.db.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.dto.MemSignUpDTO;
import com.db.resume.ResumeCareerDto;
import com.db.resume.ResumeCertiflcateDto;
import com.db.resume.ResumeMyImgDto;
import com.db.resume.ResumeSchoolDto;
import com.db.resume.ResumeVo;

@Controller
public class ResumeAjaxController {
	
	private ResumeVo resumeVo;

	//생성자에 ResumeVo 주입
	public ResumeAjaxController(ResumeVo resumeVo) {
		this.resumeVo = resumeVo;
	}

//img
	
	//insert
	@RequestMapping("/insertMyImg.do")
	public String insertMyImg(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = dto.getMem_useremail();
		int result = resumeVo.insertMyImg(mEmail, request);
		
		JSONObject obj = new JSONObject();
		if(result == 0) {
			obj.put("code", 500);
			obj.put("message", "전송 실패.");
			obj.put("result", "None");
		}else {
			obj.put("code", 200);
			obj.put("message", "전송성공.");
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//select
	@RequestMapping("/selectImg.do")
	public String selectImg(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = dto.getMem_useremail();
		System.out.println(mEmail);
		List<ResumeMyImgDto> list = resumeVo.selectMyImg(mEmail);
		
		JSONObject obj = new JSONObject();
		if(list.size() == 0) {
			obj.put("code", 500);
			obj.put("message", "전송 실패.");
			obj.put("result", "None");
		}else {
			obj.put("code", 200);
			obj.put("message", "전송성공.");
			obj.put("result", new JSONArray(list));
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//school
	
	//insert
	@RequestMapping("/insertSchool.do")
	public String insertSchool(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = dto.getMem_useremail();
		
		int result = resumeVo.insertSchool(mEmail, request);
		
		JSONObject obj = new JSONObject();
		if(result == 0) {
			obj.put("code", 500);
			obj.put("message", "전송 실패.");
			obj.put("result", "None");
		}else {
			obj.put("code", 200);
			obj.put("message", "전송성공.");
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//delete
	@RequestMapping("/deleteSchool.do")
	public String deleteSchool(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = dto.getMem_useremail();
		
		int result = resumeVo.deleteSchool(mEmail, request);
		
		JSONObject obj = new JSONObject();
		if(result == 0) {
			obj.put("code", 500);
			obj.put("message", "전송 실패.");
			obj.put("result", "None");
		}else {
			obj.put("code", 200);
			obj.put("message", "삭제성공.");
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//select
	@RequestMapping("/selectSchool.do")
	public String selectSchool(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
			
		MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
		String mEmail = dto.getMem_useremail();
		List<ResumeSchoolDto> list = resumeVo.selectSchool(mEmail);
			
		JSONObject obj = new JSONObject();
		if(list.size() == 0) {
			obj.put("code", 500);
			obj.put("message", "전송 실패.");
			obj.put("result", "None");
		}else {
			obj.put("code", 200);
			obj.put("message", "전송성공.");
			obj.put("result", new JSONArray(list));
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

//certificate
	
	//insert
		@RequestMapping("/insertCertificate.do")
		public String insertCertificate(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			
			int result = resumeVo.insertCertificate(mEmail, request);
			
			JSONObject obj = new JSONObject();
			if(result == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "전송성공.");
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
	//delete
		@RequestMapping("/deleteCertificate.do")
		public String deleteCertificate(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			
			int result = resumeVo.deleteCertificate(mEmail, request);
			
			JSONObject obj = new JSONObject();
			if(result == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "삭제성공.");
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
	//select
		@RequestMapping("/selectCertificate.do")
		public String selectCertificate(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
				
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			List<ResumeCertiflcateDto> list = resumeVo.selectCertificate(mEmail);
				
			JSONObject obj = new JSONObject();
			if(list.size() == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "전송성공.");
				obj.put("result", new JSONArray(list));
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
//Career
		
		//insert
		@RequestMapping("/insertCareer.do")
		public String insertCareer(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
			
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			
			int result = resumeVo.insertCareer(mEmail, request);
			
			JSONObject obj = new JSONObject();
			if(result == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "전송성공.");
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		//delete
		@RequestMapping("/deleteCareer.do")
		public String deleteCareer(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			
			int result = resumeVo.deleteCareer(mEmail, request);
			
			JSONObject obj = new JSONObject();
			if(result == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "삭제성공.");
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		//select
		@RequestMapping("/selectCareer.do")
		public String selectCareer(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
			
			MemSignUpDTO dto = (MemSignUpDTO)session.getAttribute("member");
			String mEmail = dto.getMem_useremail();
			List<ResumeCareerDto> list = resumeVo.selectCareer(mEmail);
			
			JSONObject obj = new JSONObject();
			if(list.size() == 0) {
				obj.put("code", 500);
				obj.put("message", "전송 실패.");
				obj.put("result", "None");
			}else {
				obj.put("code", 200);
				obj.put("message", "전송성공.");
				obj.put("result", new JSONArray(list));
			}
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
}
