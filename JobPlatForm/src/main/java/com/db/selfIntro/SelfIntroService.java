package com.db.selfIntro;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.mapper.SelfIntroMapper;

@Service
public class SelfIntroService {
	
	//mapper 연결
	private SelfIntroMapper mapper;
	
	public SelfIntroService(SelfIntroMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	//insert
	public int insertSelfIntro(SelfIntroDto dto) {
		return mapper.insertSelfIntro(dto);
	}
	
	//update
	public int updateSelfIntro(SelfIntroDto dto) {
		return mapper.updateSelfIntro(dto);
	}
	
	//delete
	public int deleteSelfIntro(int introNo) {
		return mapper.deleteSelfIntro(introNo);
	}
	
	//ListAll get
	public List<SelfIntroDto> selectAllSelfIntro(String mEmail){
		return mapper.selectAllSelfIntro(mEmail);
	}
	
	//ListAll get
	public SelfIntroDto selectSelfIntro(SelfIntroDto dto){
		return mapper.selectSelfIntro(dto);
	}

}
