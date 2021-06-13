package com.db.dto;

import java.time.LocalDateTime;

public class ComSignUpDTO {
	private String com_useremail;
	private String com_password;
	private String com_name;
	private String com_roadAddr;
	private String com_addrDetail;
	private String com_tel;
	private String com_img;
	private LocalDateTime sysdate;
	private String appr;
	
	public LocalDateTime getSysdate() {
		return sysdate;
	}
	public void setSysdate(LocalDateTime sysdate) {
		this.sysdate = sysdate;
	}
	public String getAppr() {
		return appr;
	}
	public void setAppr(String appr) {
		this.appr = appr;
	}
	public String getCom_useremail() {
		return com_useremail;
	}
	public void setCom_useremail(String com_useremail) {
		this.com_useremail = com_useremail;
	}
	public String getCom_password() {
		return com_password;
	}
	public void setCom_password(String com_password) {
		this.com_password = com_password;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_roadAddr() {
		return com_roadAddr;
	}
	public void setCom_roadAddr(String com_roadAddr) {
		this.com_roadAddr = com_roadAddr;
	}
	public String getCom_addrDetail() {
		return com_addrDetail;
	}
	public void setCom_addrDetail(String com_addrDetail) {
		this.com_addrDetail = com_addrDetail;
	}
	public String getCom_tel() {
		return com_tel;
	}
	public void setCom_tel(String com_tel) {
		this.com_tel = com_tel;
	}
	public String getCom_img() {
		return com_img;
	}
	public void setCom_img(String com_img) {
		this.com_img = com_img;
	}
	
}
