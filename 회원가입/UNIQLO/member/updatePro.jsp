<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="shopDB.ShopDBbean"%>
<%@page import="shopDB.ShopDataBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");


String userid		 = (String)session.getAttribute("id");
String name	 		 = request.getParameter("name");
String updataPasswd  = request.getParameter("updataPasswd");
String reg			 = request.getParameter("reg_date");
Timestamp reg_date   = Timestamp.valueOf(reg);
String updateid 	 = "";
String tel		     = "";
ShopDataBean data	 = null;

//eamil값 합침
for(int i = 1; i <= 2; i++){
	updateid += request.getParameter("email"+i);
	if(i < 2){
		updateid += "@";
	}
}
//tel값 합침
for(int i = 1; i <= 3; i++){
	tel += request.getParameter("tel"+i);
	if(i < 3){
		tel += "-";
	}
}

//id 중복 체크
ShopDBbean shopDBBean = ShopDBbean.getShopDBbean();
int idCheck = shopDBBean.userCheck(updateid);


if((idCheck != 1) && (!userid.equals(updateid))){
	JOptionPane.showMessageDialog(null, "아이디가 존재합니다.");
	response.sendRedirect("updateForm.jsp");
}else{
	
	data = new ShopDataBean();
	
	data.setId(updateid);
	data.setPasswd(updataPasswd);
	data.setName(name);
	data.setTel(tel);
	data.setRag_date(reg_date);
	
	//회원 정보 수정
	shopDBBean.userUpdate(data,userid);
	
	response.sendRedirect("../index.jsp");
}

%>
