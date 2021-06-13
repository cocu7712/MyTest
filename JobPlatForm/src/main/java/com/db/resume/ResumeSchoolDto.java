package com.db.resume;

import lombok.Data;

@Data
public class ResumeSchoolDto {
	private int no;
	private String mEmail;
	private String school;			//학교
	private String schoolDetail;	//학교 상세정보
	private String admission;		//입학
	private String graduated;		//졸업
	
	public ResumeSchoolDto(String mEmail, String school, String schoolDetail, String admission, String graduated) {
		this.mEmail = mEmail;
		this.school = school;
		this.schoolDetail = schoolDetail;
		this.admission = admission;
		this.graduated = graduated;
	}
	
	public ResumeSchoolDto(int no, String mEmail, String school, String schoolDetail, String admission, String graduated) {
		this.no = no;
		this.mEmail = mEmail;
		this.school = school;
		this.schoolDetail = schoolDetail;
		this.admission = admission;
		this.graduated = graduated;
	}

	public ResumeSchoolDto(int no, String mEmail) {
		this.no = no;
		this.mEmail = mEmail;
	}

	public ResumeSchoolDto() {
		
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchoolDetail() {
		return schoolDetail;
	}

	public void setSchoolDetail(String schoolDetail) {
		this.schoolDetail = schoolDetail;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	public String getGraduated() {
		return graduated;
	}

	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}

	
	
}
