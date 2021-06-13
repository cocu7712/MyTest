package com.db.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.mapper.ApplyMapper;

@Service
public class ApplyService {
	@Autowired
	private ApplyMapper mapper;
	
	public ApplyService(ApplyMapper mapper){
		this.mapper = mapper;
	}
	
	public List<ApplyDto> selectIntroTitle(String mEmail){
		return mapper.selectIntroTitle(mEmail);
	}
	
	public void applCompany(int no, int introNo) {
		mapper.applyCompany(no, introNo);
	}
	
	public List<ApplyDto> selectByEmail(String mEmail){
		return mapper.applyCompanyByMember(mEmail);
	}
	
}
