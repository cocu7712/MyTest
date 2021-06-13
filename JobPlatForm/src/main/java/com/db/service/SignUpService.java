package com.db.service;


import org.springframework.stereotype.Service;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;
import com.db.mapper.SignUpMapper;

@Service
public class SignUpService {
	private SignUpMapper mapper;
	
	public SignUpService(SignUpMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public int insertMem(MemSignUpDTO memSignUpDTO){
		return mapper.insertMem(memSignUpDTO);
	}
	
	public int insertCom(ComSignUpDTO comSignUpDTO) {
		return mapper.insertCom(comSignUpDTO);
	}
	
	public int selectUserEmail(String member_email) {
		return mapper.selectUserEmail(member_email);
	}
	
	public int selectCompanyEmail(String company_email) {
		return mapper.selectCompanyEmail(company_email);
	}
	
	public MemSignUpDTO selectUser(String email) {
		return mapper.selectUser(email);
	}
	
	
}
