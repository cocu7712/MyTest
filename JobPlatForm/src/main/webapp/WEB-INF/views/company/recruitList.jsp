<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>회사_모집공고 등록 페이지</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/recruitRegistStyle.css'>
	
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/main-aside.jsp" />
	<jsp:include page="../include/comAside.jsp" />

	<h2>모집 공고 목록</h2>

	<div class="container">
		
		<div class="row">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>첫 번째 모집공고</td>
						<td>2021-06-01</td>
					</tr>
				</tbody>
			</table>
			<a href="recruitRegist.jsp" class="btn-btn-primary pull-right">등록하기</a>
		</div>
		
	</div>

	<div>
		<jsp:include page="../include/footer.jsp" />
	</div>
</body>

</html>