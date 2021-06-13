package com.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.db.resume.ResumeCareerDto;
import com.db.resume.ResumeCertiflcateDto;
import com.db.resume.ResumeMyImgDto;
import com.db.resume.ResumeSchoolDto;

@Mapper
public interface ResumeMapper {

	//이미지
	public int insertMyImg(ResumeMyImgDto dto);
	public List<ResumeMyImgDto> selectMyImg(String mEmail);
	
	//학교
	public int insertSchool(ResumeSchoolDto dto);
	public int deleteSchool(ResumeSchoolDto dto);
	public List<ResumeSchoolDto> selectSchool(String mEmail);
	
	//자격증
	public int insertCertificate(ResumeCertiflcateDto dto);
	public int deleteCertificate(ResumeCertiflcateDto dto);
	public List<ResumeCertiflcateDto> selectCertificate(String mEmail);
	
	//자격증
	public int insertCareer(ResumeCareerDto dto);
	public int deleteCareer(ResumeCareerDto dto);
	public List<ResumeCareerDto> selectCareer(String mEmail);
}
