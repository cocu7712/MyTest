package com.db.resume;

import lombok.Data;

@Data
public class ResumeMyImgDto {
	private String mEmail;
	private String res_img;
	
	public ResumeMyImgDto(String mEmail, String res_img) {
		this.mEmail = mEmail;
		this.res_img = res_img;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getRes_img() {
		return res_img;
	}

	public void setRes_img(String res_img) {
		this.res_img = res_img;
	}
	
}
