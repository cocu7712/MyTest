<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="members.js"></script>
</head>
<body>
	<form action="joinOk.jsp" method="post" name="reg_frm">
	아이디 : <input type="text" name="id" size="20"><br>
	비밀번호 : <input type="password" name="pw" size="20"><br>
	비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
	이름 : <input type="text" name="name" size="20"><br>
	메일 : <input type="text" name="eMail" size="20"><br>
	주소 : <input type="text" name="address" size="50"><br>
	<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>