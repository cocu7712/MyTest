<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>잡코잇</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/main-section.css'>
<link rel = 'stylesheet' type = "text/css" media = 'screen' href = "${contextPath}/resources/styles/recruit.css">
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/main-aside.jsp" />
<section class="main-banner">
	<img src="${contextPath}/resources/images/banner.png">
</section>
	<section class="main-search">
		<article class="search">
			<select name="searchBy" id="searchBy">
				<option>검색어</option>
				<option id="category" value="category">카테고리</option>
				<option id="career" value="career">경력</option>
				<option id="comName" value="comName">기업명</option>
			</select> <input type="text" name="word" id="main-search" class="main-search"
				placeholder=" 검색어를 입력해주세요"> &nbsp;&nbsp;&nbsp;&nbsp; <input
				type="button" id="btn_search" value="검색"
				style="width: 80px; height: 50px;">
		</article>
	</section>

<h1>추천공고</h1>
		<div class = "recruit">
			<c:forEach var="dto" items="${recruit}">
			<a href = "recruit/detail/${dto.no }">
				<div class="container">
						<img src = "${contextPath}/${dto.img}">
						<div class = "comName">
							<h3>${dto.comName}</h3>
							<h4 class = "category">${dto.title }<br>
							카테고리 : ${dto.category }<br>
							경력 : ${dto.career }
							</h4>
						</div>
				</div>
			</a>
			</c:forEach>
		</div>

   
		
<div>
<jsp:include page="../include/footer.jsp"/>
</div>
</body>
</html>