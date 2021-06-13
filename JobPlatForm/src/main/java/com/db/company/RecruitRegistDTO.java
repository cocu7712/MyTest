package com.db.company;

import java.util.List;

import lombok.Data;

@Data
public class RecruitRegistDTO {
	private int recruit_No;
	private String recrutiTitle;
	private String Category;
	private List<String> Tag;
	private String Text1;
	private String Text2;
	private String Text3;
	private String Text4;
	private String Text5;

	public RecruitRegistDTO() {
		
	}
	
	public RecruitRegistDTO(int recruit_No, String recrutiTitle, String Category, List<String> Tag, String Text1, String Text2, String Text3, String Text4, String Text5) {
		this.recruit_No = recruit_No;
		this.recrutiTitle = recrutiTitle;
		this.Category = Category;
		this.setTag(Tag);
		this.Text1 = Text1;
		this.Text2 = Text2;
		this.Text3 = Text3;
		this.Text4 = Text4;
		this.Text5 = Text5;
	}

	public int getRecruit_No() {
		return recruit_No;
	}

	public void setRecruit_No(int recruit_No) {
		this.recruit_No = recruit_No;
	}

	public String getRecrutiTitle() {
		return recrutiTitle;
	}

	public void setRecrutiTitle(String recrutiTitle) {
		this.recrutiTitle = recrutiTitle;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getText1() {
		return Text1;
	}

	public void setText1(String text1) {
		Text1 = text1;
	}

	public String getText2() {
		return Text2;
	}

	public void setText2(String text2) {
		Text2 = text2;
	}

	public String getText3() {
		return Text3;
	}

	public void setText3(String text3) {
		Text3 = text3;
	}

	public String getText4() {
		return Text4;
	}

	public void setText4(String text4) {
		Text4 = text4;
	}

	public String getText5() {
		return Text5;
	}

	public void setText5(String text5) {
		Text5 = text5;
	}

	public List<String> getTag() {
		return Tag;
	}

	public void setTag(List<String> tag) {
		Tag = tag;
	}
	
	
}