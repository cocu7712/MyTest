package com.db.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;

@Mapper
public interface LoginMapper {
	public MemSignUpDTO selectKakao(String email);
	public MemSignUpDTO selectmember(HashMap<String, String> map);
	public ComSignUpDTO selectcompany(HashMap<String, String> map);
	public int countemail(String kakao);
}
