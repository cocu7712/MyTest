package com.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.db.company.RecruitRegistDTO;

@Mapper
public interface RecruitRegistMapper {

	public List<RecruitRegistDTO> selectAllRecruitRegist(int recruit_No);
	public RecruitRegistDTO selectRecruitRegist(RecruitRegistDTO dto);
	public int insertRecruitRegist(RecruitRegistDTO dto);
	public int updateRecruitRegist(RecruitRegistDTO dto);
	public int deleteRecruitRegist(int recruit_No);
	
}
