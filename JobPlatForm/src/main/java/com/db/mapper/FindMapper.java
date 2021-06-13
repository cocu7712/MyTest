package com.db.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FindMapper {
	public int selectSearch(HashMap<String, String> EmailFind);
	public String FindUserEmail(HashMap<String, String> EmailFind);
}
