package com.db.resume;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ResumeVo {

	private ResumeService service;

	//생성자에 service 주입
	public ResumeVo(ResumeService service) {
		this.service = service;
	}
//img
	
	//이미지등록
	public int insertMyImg(String mEmail,HttpServletRequest request) {
		String res_img = request.getParameter("res_img");
		return service.insertMyImg(new ResumeMyImgDto(mEmail, res_img));
	}
	
	//이미지가져오기
	public List<ResumeMyImgDto> selectMyImg(String mEmail) {
		return service.selectMyImg(mEmail);
	} 

//school
	
	//학교 등록
	public int insertSchool(String mEmail,HttpServletRequest request) {
	
		//셋팅용 데이터 
		String school = request.getParameter("school");
		String schoolDetail = request.getParameter("schoolDetail");
		String admission = request.getParameter("admission");
		String graduated = request.getParameter("graduated");
		
		return service.insertSchool(new ResumeSchoolDto(mEmail, school, schoolDetail, admission, graduated));
	}
	
	//학교 삭제
	public int deleteSchool(String mEmail,HttpServletRequest request) {
		
		//셋팅용 데이터 
		int no = Integer.parseInt(request.getParameter("no"));
		
		return service.deleteSchool(new ResumeSchoolDto(no, mEmail));
	}	
	
	//학교 전체 데이터
	public List<ResumeSchoolDto> selectSchool(String mEmail) {
		
		return service.selectSchool(mEmail);
	}	
	
	
//certificate
	
	//자격증 등록
	public int insertCertificate(String mEmail,HttpServletRequest request) {
		
		//셋팅용 데이터 
		String certificate = request.getParameter("certificate");
		String issuer = request.getParameter("issuer");
		String getDate = request.getParameter("getDate");
		
		return service.insertCertificate(new ResumeCertiflcateDto(mEmail, certificate, issuer, getDate));
	}
	
	//학교 삭제
	public int deleteCertificate(String mEmail,HttpServletRequest request) {
		
		//셋팅용 데이터 
		int no = Integer.parseInt(request.getParameter("no"));
		
		return service.deleteCertificate(new ResumeCertiflcateDto(no, mEmail));
	}	
	
	//학교 전체 데이터
	public List<ResumeCertiflcateDto> selectCertificate(String mEmail) {
		
		return service.selectCertificate(mEmail);
	}	
	
//Career
	
	//경력 등록
	public int insertCareer(String mEmail,HttpServletRequest request) {
		
		//셋팅용 데이터 
		String position = request.getParameter("position");
		String company = request.getParameter("company");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		return service.insertCareer(new ResumeCareerDto(mEmail, position, company, startDate, endDate));
	}
	
	//경력 삭제
	public int deleteCareer(String mEmail,HttpServletRequest request) {
		
		//셋팅용 데이터 
		int no = Integer.parseInt(request.getParameter("no"));
		
		return service.deleteCareer(new ResumeCareerDto(no, mEmail));
	}	
	
	//경력 전체 데이터
	public List<ResumeCareerDto> selectCareer(String mEmail) {
		
		return service.selectCareer(mEmail);
	}	
	
}
