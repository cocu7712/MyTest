package com.db.selfIntro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class SelfIntroVo {
	
	private SelfIntroService service;

	//생성자에 service 주입
	public SelfIntroVo(SelfIntroService service) {
		this.service = service;
	}
	
	public int selfIntroInsert(HttpServletRequest request,String mEmail) {
		
		String title = request.getParameter("title");
		String intro_text1 = request.getParameter("intro_text1");
		String intro_text2 = request.getParameter("intro_text2");
		String intro_text3 = request.getParameter("intro_text3");
		String intro_text4 = request.getParameter("intro_text4");
		
		int result = service.insertSelfIntro(new SelfIntroDto(mEmail, intro_text1, intro_text2, intro_text3, intro_text4, title));		
		return result;
	}
	
		//전체 자소서 리스트 가져오기
		public List<SelfIntroDto> selectAllSelfIntro(String mEmail){
		
		List<SelfIntroDto> list = service.selectAllSelfIntro(mEmail);
		return list;
	}
	
	//선택한 한개의 자소서 가져오기
	public SelfIntroDto selectSelfIntro(HttpServletRequest request,String mEmail){
		
		int introNo;	//자소서 no값
		
		try {
			introNo = Integer.parseInt(request.getParameter("no"));
		} catch (Exception e) {
			introNo = 0;
		}
		
		SelfIntroDto dto = service.selectSelfIntro(new SelfIntroDto(introNo, mEmail));
		
		return dto;
	}
	
	//수정
	public int selfIntroUpdate(HttpServletRequest request,String mEmail){
		
		int introNo = Integer.parseInt(request.getParameter("no"));
		String intro_text1 = request.getParameter("intro_text1");
		String intro_text2 = request.getParameter("intro_text2");
		String intro_text3 = request.getParameter("intro_text3");
		String intro_text4 = request.getParameter("intro_text4");
		String title = request.getParameter("title");
		
		int result = service.updateSelfIntro(new SelfIntroDto(introNo, intro_text1, intro_text2, intro_text3, intro_text4, title));
		
		
		return result;
	}
	
	
	//삭제
	public int selfIntroDelete(HttpServletRequest request,String mEmail) {
		
		
		int introNo = Integer.parseInt(request.getParameter("no"));
		int result = service.deleteSelfIntro(introNo);	//삭제
		
		return result;
	}
	
}
