package com.db.company;

import lombok.Data;

@Data
public class RecruitListDTO {

	private int list_No;
	private String recrutiTitle;
	private String reg_date;
	
	public RecruitListDTO(int list_No, String recrutiTitle, String reg_date) {
		this.list_No = list_No;
		this.recrutiTitle = recrutiTitle;
		this.reg_date = reg_date;
	}
	
	public RecruitListDTO() {
		
	}

	public int getList_No() {
		return list_No;
	}

	public void setList_No(int list_No) {
		this.list_No = list_No;
	}

	public String getRecrutiTitle() {
		return recrutiTitle;
	}

	public void setRecrutiTitle(String recrutiTitle) {
		this.recrutiTitle = recrutiTitle;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}
