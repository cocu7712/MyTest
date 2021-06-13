package com.db.recruit;

public class RecruitDto {
	private String img;
	private String comName;
	private String tel;
	private String fax = "";
	private String roadAddr = "";
	private int no;
	private String title;
	private String tag;
	private String[] recruitTag;
	private String career;
	private String category;
	private String text1;
	private String text2;
	private String text3;
	private String text4;
	private String text5;
	
	public RecruitDto(int no, String comName, String category, String title, String career, String text1, String text2,
			String text3, String text4, String text5) {
		this.no = no;
		this.comName = comName;
		this.title = title;
		this.career = career;
		this.category = category;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;
	}
	public RecruitDto() {}
	public RecruitDto(String img, String comName, String tel, String fax, String roadAddr, int no, String title,
			String tag, String career, String category, String text1, String text2, String text3, String text4,
			String text5) {
		this.img = img;
		this.comName = comName;
		this.tel = tel;
		this.fax = fax;
		this.roadAddr = roadAddr;
		this.no = no;
		this.title = title;
		this.tag = tag;
		this.career = career;
		this.category = category;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
	public String getText4() {
		return text4;
	}
	public void setText4(String text4) {
		this.text4 = text4;
	}
	public String getText5() {
		return text5;
	}
	public void setText5(String text5) {
		this.text5 = text5;
	}
	
	public String[] getRecruitTag() {
		return recruitTag;
	}
	public void setRecruitTag(String[] recruitTag) {
		this.recruitTag = recruitTag;
	}
	
}
