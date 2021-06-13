package com.db.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.db.recruit.RecruitDto;

@Mapper
public interface RecruitMapper {
	public List<RecruitDto> selectAllRecruit();
	public List<RecruitDto> selectRecruitBy(HashMap<String, Object> map);
	public List<RecruitDto> selectRecruitByCategory(String category);
	public RecruitDto selectRecruitByNo(int no);
	public List<String> selectTagByString(int no);
	public List<RecruitDto> selectTag(int no);
}
