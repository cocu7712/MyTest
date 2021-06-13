package com.db.resume;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.mapper.ResumeMapper;

@Service
public class ResumeService {
	
	//mapper 연결
	private ResumeMapper mapper;
		
	//생성자
	public ResumeService(ResumeMapper mapper) {
		this.mapper = mapper;
	}
	
//이미지
	//등록
	public int insertMyImg(ResumeMyImgDto dto) {
		return mapper.insertMyImg(dto);
	}
	//가져오기
	public List<ResumeMyImgDto> selectMyImg(String mEmail) {
		return mapper.selectMyImg(mEmail);
	}
	
//학교
	//입력
	public int insertSchool(ResumeSchoolDto dto) {
		return mapper.insertSchool(dto);
	}
	//삭제
	public int deleteSchool(ResumeSchoolDto dto) {
		return mapper.deleteSchool(dto);
	}
	//가져오기
	public List<ResumeSchoolDto> selectSchool(String mEmail) {
		return mapper.selectSchool(mEmail);
	}
	
//자격증
	//입력
	public int insertCertificate(ResumeCertiflcateDto dto) {
		return mapper.insertCertificate(dto);
	}
	//삭제
	public int deleteCertificate(ResumeCertiflcateDto dto) {
		return mapper.deleteCertificate(dto);
	}
	//가져오기
	public List<ResumeCertiflcateDto> selectCertificate(String mEmail) {
		return mapper.selectCertificate(mEmail);
	}
	
//경력
	//입력
	public int insertCareer(ResumeCareerDto dto) {
		return mapper.insertCareer(dto);
	}
	//삭제
	public int deleteCareer(ResumeCareerDto dto) {
		return mapper.deleteCareer(dto);
	}
	//가져오기
	public List<ResumeCareerDto> selectCareer(String mEmail) {
		return mapper.selectCareer(mEmail);
	}
	
}
