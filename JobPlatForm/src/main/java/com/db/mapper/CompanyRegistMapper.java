package com.db.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.db.recruit.RecruitDto;

@Mapper
public interface CompanyRegistMapper {
	public void registRecruit(RecruitDto dto);

	public int getSequence();
	
	public void insertTag(int no, String tag);
}