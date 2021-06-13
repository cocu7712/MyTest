package com.db.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;
import com.db.mapper.LoginMapper;

@Service
public class LoginService {
	private LoginMapper mapper;
	
	public LoginService(LoginMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public MemSignUpDTO selectKakao(String email) {
		return mapper.selectKakao(email);
	}
	public MemSignUpDTO selectmember(HashMap<String, String> map){
		return mapper.selectmember(map);
	}
	
	public ComSignUpDTO selectcompany(HashMap<String, String> map) {
		return mapper.selectcompany(map);
	}
	
	public int countemail(String kakao) {
		return mapper.countemail(kakao);
	}
	
	
	
}
