<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.db.recruit.RecruitDto" %>
<%@ page import = "com.db.apply.ApplyDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>팀플 메인</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/main-section.css'>
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class = "container">
		<form method = "post" name = "frm">
			<select name = "selfIntro" value = "선택">
			<option value = "choice">선택</option>
		<c:forEach var = "apply" items = "${dto}" varStatus = "i">
				<option value = "${apply.introno}">${apply.title }</option>
		</c:forEach>
			</select>	
			<input type = "button" value = "지원하기" class = "w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" onclick = "applyForm(this.form)">
		</form>	
	</div>

	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script>
		function applyForm(frm){
			if(frm.selfIntro.value === 'choice'){
				alert('자기소개서를 선택해주세요.');
				return false;
			}
			
			frm.action = "apply";
			frm.submit();
		}
	</script>
</body>
</html>