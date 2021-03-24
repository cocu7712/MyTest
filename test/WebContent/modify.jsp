<%@page import="t1.MemberDto"%>
<%@page import="t1.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id =(String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);
	
	if(dao.conFirmId(dto.getId()) == 1){
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="members.js"></script>
</head>
<body>

	<form action="modifyOk.jsp" method="post" name="reg_frm">
	아이디 : <%= dto.getId() %><br>
	비밀번호 : <input type="password" name="pw" size="20"><br>
	비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
	이름 : <%= dto.getName() %><br>
	메일 : <input type="text" name="eMail" value="<%= dto.geteMail()%>" size="20"><br>
	주소 : <input type="text" name="address" value="<%= dto.getAddress()%>" size="50"><br>
	<input type="button" value="수정" onclick="updateInfoConfirm()">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>

<%}%>
</body>
</html>