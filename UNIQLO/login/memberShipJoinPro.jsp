<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="shopDB.ShopDBbean"%>
<%@page import="shopDB.ShopDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");


String name	  = request.getParameter("name");
String passwd = request.getParameter("passwd");
Timestamp reg_date = new Timestamp(System.currentTimeMillis());
String id 	  = "";
String tel	  = "";

//eamil값 합침
for(int i = 1; i <= 2; i++){
	id += request.getParameter("email"+i);
	if(i < 2){
		id += "@";
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
int idCheck = shopDBBean.userCheck(id);

if(idCheck != 1){
	JOptionPane.showMessageDialog(null, "아이디가 존재합니다.");
	response.sendRedirect("memberShipJoin.jsp");
}else{
	
	ShopDataBean data = new ShopDataBean();
	
	data.setName(name);
	data.setId(id);
	data.setPasswd(passwd);
	data.setTel(tel);
	data.setRag_date(reg_date);
	
	//회원 등록
	shopDBBean.userInsert(data);
	
	response.sendRedirect("login.jsp");
}

%>