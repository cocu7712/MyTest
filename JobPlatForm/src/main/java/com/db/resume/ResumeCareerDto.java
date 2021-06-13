package com.db.resume;

import lombok.Data;

@Data
public class ResumeCareerDto {
	private int no;
	private String mEmail;
	private String position;
	private String company;
	private String startDate;
	private String endDate;
	
	public ResumeCareerDto(String mEmail, String position, String company, String startDate, String endDate) {
		this.mEmail = mEmail;
		this.position = position;
		this.company = company;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ResumeCareerDto(int no, String mEmail) {
		this.no = no;
		this.mEmail = mEmail;
	}
	
	public ResumeCareerDto() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
}
