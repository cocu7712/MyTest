package com.db.recruit;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.mapper.RecruitMapper;

@Service
public class RecruitService {
	@Autowired
	private RecruitMapper mapper;
	
	public RecruitService(RecruitMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<RecruitDto> selectAllRecruit(){
		return mapper.selectAllRecruit();
	}
	

	public List<RecruitDto> selectRecruitBy(String searchBy, String word) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", searchBy);
		map.put("word", word);
		return mapper.selectRecruitBy(map);
	}
	
	public List<RecruitDto> selectRecruitByCategory(String category){
		return mapper.selectRecruitByCategory(category);
	}
	
	public RecruitDto selectRecruitByNo(int no) {
		return mapper.selectRecruitByNo(no);
	}
	
	public List<String> selectTagByString(int no){
		return mapper.selectTagByString(no);
	}

	public List<RecruitDto> selectTag(int no){
		return mapper.selectTag(no);
	}
}
