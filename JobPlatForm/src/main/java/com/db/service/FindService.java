package com.db.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.db.mapper.FindMapper;

@Service
public class FindService {
private FindMapper mapper;
	
	public FindService(FindMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public int selectSearch(HashMap<String, String> EmailFind) {
		return mapper.selectSearch(EmailFind);
	}
	
	public String FindUserEmail(HashMap<String, String> EmailFind) {
		return mapper.FindUserEmail(EmailFind);
	}
}
