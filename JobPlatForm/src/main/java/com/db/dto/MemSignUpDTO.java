package com.db.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemSignUpDTO {
	private String mem_useremail;
	private String mem_password;
	private String mem_sex;
	private String mem_birth_year;
	private String mem_birth_month;
	private String mem_birth_day;
	private LocalDate mem_birth;
	private String mem_name;
	private String mem_phone;
	private String mem_roadAddr;
	private String mem_addrDetail;
	private LocalDateTime mem_sysdate;
	
	public LocalDateTime getMem_sysdate() {
		return mem_sysdate;
	}
	public void setMem_sysdate(LocalDateTime mem_sysdate) {
		this.mem_sysdate = mem_sysdate;
	}
	
	
	public String getMem_useremail() {
		return mem_useremail;
	}
	public void setMem_useremail(String mem_useremail) {
		this.mem_useremail = mem_useremail;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public String getMem_sex() {
		return mem_sex;
	}
	public void setMem_sex(String mem_sex) {
		this.mem_sex = mem_sex;
	}
	public String getMem_birth_year() {
		return mem_birth_year;
	}
	public void setMem_birth_year(String mem_birth_year) {
		this.mem_birth_year = mem_birth_year;
	}
	public String getMem_birth_month() {
		return mem_birth_month;
	}
	public void setMem_birth(LocalDate mem_birth) {
		this.mem_birth = mem_birth;
	}
	public void setMem_birth_month(String mem_birth_month) {
		this.mem_birth_month = mem_birth_month;
	}
	public String getMem_birth_day() {
		return mem_birth_day;
	}
	public void setMem_birth_day(String mem_birth_day) {
		this.mem_birth_day = mem_birth_day;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_roadAddr() {
		return mem_roadAddr;
	}
	public void setMem_roadAddr(String mem_roadAddr) {
		this.mem_roadAddr = mem_roadAddr;
	}
	public String getMem_addrDetail() {
		return mem_addrDetail;
	}
	public void setMem_addrDetail(String mem_addrDetail) {
		this.mem_addrDetail = mem_addrDetail;
	}
	public void setMem_birth() {
		this.mem_birth = LocalDate.parse(this.mem_birth_year+"-"+this.mem_birth_month+"-"+this.mem_birth_day);
	}
	public LocalDate getMem_birth() {
		return mem_birth;
	}
	
}
