<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ShopDBbean" class="shopDB.ShopDBbean"></jsp:useBean>
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

int userCheck = ShopDBbean.userCheck(id, passwd);

//아이디랑 비밀번호가 맞으면 세션에 저장
if(1 == userCheck){
	session.setAttribute("id", id);
	response.sendRedirect("../index.jsp");
}else if(0 == userCheck){
	JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
	response.sendRedirect("memberShipJoin.jsp");
}else{
	JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
	response.sendRedirect("memberShipJoin.jsp");
}
%>
