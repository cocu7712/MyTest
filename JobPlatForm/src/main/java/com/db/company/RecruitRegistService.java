package com.db.company;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.mapper.RecruitRegistMapper;

@Service
public class RecruitRegistService {

	private RecruitRegistMapper mapper;
	
	public RecruitRegistService(RecruitRegistMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public int insertRecruitRegist(RecruitRegistDTO dto) {
		return mapper.insertRecruitRegist(dto);
	}
	
	public int updateRecruitRegist(RecruitRegistDTO dto) {
		return mapper.updateRecruitRegist(dto);
	}
	
	public int deleteRecruitRegist(int recruit_No) {
		return mapper.deleteRecruitRegist(recruit_No);
	}
	
	public List<RecruitRegistDTO> selectAllRecruitRegist(int recruit_No) {
		return mapper.selectAllRecruitRegist(recruit_No);
	}
	
}
