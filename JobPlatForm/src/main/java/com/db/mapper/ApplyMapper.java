package com.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.db.apply.ApplyDto;

@Mapper
public interface ApplyMapper {
	public List<ApplyDto> selectIntroTitle(String mEmail);
	
	public void applyCompany(int no, int introNo);
	public List<ApplyDto> applyCompanyByMember(String mEmail);
}
