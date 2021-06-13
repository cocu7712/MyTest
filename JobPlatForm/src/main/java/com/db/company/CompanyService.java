package com.db.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.mapper.CompanyRegistMapper;
import com.db.recruit.RecruitDto;

@Service
public class CompanyService {
	@Autowired
	private CompanyRegistMapper mapper;
	
	public CompanyService(CompanyRegistMapper mapper) {
		this.mapper = mapper;
	}

	public int getSequence() {
		return mapper.getSequence();
	}
	
	public void companyRegist(RecruitDto dto) {
		mapper.registRecruit(dto);
	}
	
	public void insertTagByNo(int no, String tag) {
		mapper.insertTag(no, tag);
	}
}
