package com.db.resume;

import lombok.Data;

@Data
public class ResumeCertiflcateDto {
	private int no;
	private String mEmail;
	private String certificate;			//자격증
	private String issuer;				//발행자
	private String getDate;				//발행일자

	public ResumeCertiflcateDto(int no, String mEmail, String certificate, String issuer, String getDate) {
		this.no = no;
		this.mEmail = mEmail;
		this.certificate = certificate;
		this.issuer = issuer;
		this.getDate = getDate;
	}

	public ResumeCertiflcateDto(String mEmail, String certificate, String issuer, String getDate) {
		this.mEmail = mEmail;
		this.certificate = certificate;
		this.issuer = issuer;
		this.getDate = getDate;
	}

	public ResumeCertiflcateDto(int no, String mEmail) {
		this.no = no;
		this.mEmail = mEmail;
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

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getGetDate() {
		return getDate;
	}

	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}
	
}
