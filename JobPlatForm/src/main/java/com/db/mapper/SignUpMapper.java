package com.db.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;

@Mapper
public interface SignUpMapper {

	public int insertMem(MemSignUpDTO memSignUpDTO);
	public int insertCom(ComSignUpDTO comSignUpDTO);
	public int selectUserEmail(String member_email);
	public int selectCompanyEmail(String company_email);
	public MemSignUpDTO selectUser(String email);

}
