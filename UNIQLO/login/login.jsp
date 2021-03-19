<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/Top.css" rel="stylesheet">
<script src="../js/shopLogin.js"></script>
</head>
<body>
<div>
<form method="post" name="login" action="loginCheck.jsp">
<table class="login_table">
<tr>
	<td class="login_logo"><h2 style="margin-bottom: 0" >&nbsp;&nbsp;&nbsp;&nbsp;로그인</h2></td>
</tr>
<tr>
	<td class="login_radio">
		<input type="checkbox" name="idSave">아이디 저장
	</td>
</tr>
<tr>
	<td class="login_td1">
		<input class="login_input_text" type="text" name="id" placeholder="아이디 (이메일)">
	</td>
</tr>
<tr>
	<td class="login_td1">
		<input class="login_input_text" type="password" name="passwd" placeholder="비밀번호">
	</td>
</tr>
<tr>
	<td class="login_td1">
		<input class="login_button" type="submit" value="로그인">
	</td>
</tr>
<tr>
	<td class="login_td1">
	<a class="a_login_td3" href="#">아이디 찾기 ></a>&nbsp;&nbsp;
	<a class="a_login_td3" href="#">비밀번호 찾기 ></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="a_login_td3" href="memberShipJoin.jsp">회원가입 ></a>
	</td>
</tr>
<tr>
	<td class="login_td1">
	-소셜 간편 로그인-
	</td>
</tr>
<tr>
</tr>
</table>
</form>
</div>
</body>
</html>