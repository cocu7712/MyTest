package com.db.selfIntro;

import lombok.Data;

@Data	//getter,setter 자동 생성
public class SelfIntroDto {
	
	private int introNo;		//자소서 no
	private String mEmail ;			//작성 id
	private String intro_text1;	//지원동기
	private String intro_text2;	//성장과정
	private String intro_text3;	//장단점
	private String intro_text4;	//입사포부
	private String title;		//자소서 저장 title
	
	//기본 생성자
	public SelfIntroDto() {
		
	};
	
	//데이터를 전체 받는 생성자
	public SelfIntroDto(String mEmail , String intro_text1, String intro_text2 , String intro_text3, String intro_text4, String title) {
		this.mEmail 		 = mEmail ;
		this.intro_text1	 = intro_text1;
		this.intro_text2	 = intro_text2;
		this.intro_text3	 = intro_text3;
		this.intro_text4	 = intro_text4;
		this.title			 = title;
	}
	
	//업데이트용 생성자
	public SelfIntroDto(int introNo, String intro_text1, String intro_text2, String intro_text3, String intro_text4,
			String title) {
		this.introNo = introNo;
		this.intro_text1 = intro_text1;
		this.intro_text2 = intro_text2;
		this.intro_text3 = intro_text3;
		this.intro_text4 = intro_text4;
		this.title = title;
	}
	

	public SelfIntroDto(int introNo, String mEmail) {
		this.introNo = introNo;
		this.mEmail = mEmail;
	}

	public int getIntroNo() {
		return introNo;
	}

	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getIntro_text1() {
		return intro_text1;
	}

	public void setIntro_text1(String intro_text1) {
		this.intro_text1 = intro_text1;
	}

	public String getIntro_text2() {
		return intro_text2;
	}

	public void setIntro_text2(String intro_text2) {
		this.intro_text2 = intro_text2;
	}

	public String getIntro_text3() {
		return intro_text3;
	}

	public void setIntro_text3(String intro_text3) {
		this.intro_text3 = intro_text3;
	}

	public String getIntro_text4() {
		return intro_text4;
	}

	public void setIntro_text4(String intro_text4) {
		this.intro_text4 = intro_text4;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}




}
