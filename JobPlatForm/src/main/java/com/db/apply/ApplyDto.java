package com.db.apply;

public class ApplyDto {
	private int no;
	private int introno;
	private String comName;
	private String img;
	private String career;
	private String category;
	private String mEmail;
	private String title;
	private String Intro_text1;
	private String Intro_text2;
	private String Intro_text3;
	private String Intro_text4;
	
	

	public ApplyDto(int no, int introno, String comName, String img, String career, String category, String mEmail,
			String title, String intro_text1, String intro_text2, String intro_text3, String intro_text4) {
		super();
		this.no = no;
		this.introno = introno;
		this.comName = comName;
		this.img = img;
		this.career = career;
		this.category = category;
		this.mEmail = mEmail;
		this.title = title;
		Intro_text1 = intro_text1;
		Intro_text2 = intro_text2;
		Intro_text3 = intro_text3;
		Intro_text4 = intro_text4;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public int getIntrono() {
		return introno;
	}



	public void setIntrono(int introno) {
		this.introno = introno;
	}



	public String getComName() {
		return comName;
	}



	public void setComName(String comName) {
		this.comName = comName;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getCareer() {
		return career;
	}



	public void setCareer(String career) {
		this.career = career;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getmEmail() {
		return mEmail;
	}



	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getIntro_text1() {
		return Intro_text1;
	}



	public void setIntro_text1(String intro_text1) {
		Intro_text1 = intro_text1;
	}



	public String getIntro_text2() {
		return Intro_text2;
	}



	public void setIntro_text2(String intro_text2) {
		Intro_text2 = intro_text2;
	}



	public String getIntro_text3() {
		return Intro_text3;
	}



	public void setIntro_text3(String intro_text3) {
		Intro_text3 = intro_text3;
	}



	public String getIntro_text4() {
		return Intro_text4;
	}



	public void setIntro_text4(String intro_text4) {
		Intro_text4 = intro_text4;
	}



	public ApplyDto() {
	}
	
	
}
