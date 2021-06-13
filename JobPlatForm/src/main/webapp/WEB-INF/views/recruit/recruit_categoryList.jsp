<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>카테고리</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
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
		<!-- <img src="https://lh3.googleusercontent.com/proxy/qdn7kI54UAPuxCNoL0whTiq0o3EjsvV1L1XW_tYjKBxzVROzF6Y2P4ldFwZuYldes47dO6IY7JQOOcclRN19jBI_677mNPkXkG2FilSjZ90SMLGMij3XcyaFj68pfEQYbCarYqjvJPIOgleZ7Zbu9_2Fd4YrkZJZA1pXencg9RsRm85OD5Ipvsso882Zb6hDPYSJdHFS11lk8id4l0ys9XbhHKuFhXaeJVKKW5SXw_tT5LId6f5mPjSnid0hLzZb1nUCORNi0SBux5ay5kabag36gRlSbUnYwIODPN6Yf_WyfhOAo-RrlRdm_mLkzXnie6RBb2g0B1DIkDFswJWzQw1mNvei"> -->
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
	
	<div id="result" style = "text-align : center;">
		<h1>추천공고</h1>
	</div>

<div class = "aa">
	<h1>추천공고</h1>
		<div class = "recruit">
			<c:forEach var="recruit" items="${dto}" varStatus="i">
			<a href = "detail/${recruit.no }">
				<div class="container">
						<img src = "${contextPath}/${recruit.img}">
						<div class = "comName">
							<h3>${recruit.comName}</h3>
							<h4 class = "category">${recruit.title }<br>
							카테고리 : ${recruit.category }<br>
							경력 : ${recruit.career }
							</h4>
						</div>
				</div>
			</a>
			</c:forEach>
		</div>
</div>
<div>
<jsp:include page="../include/footer.jsp" />
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#result").hide();
		$("#btn_search").click(function() {
			var searchBy = $("#searchBy").val();
			var keyWord = $("#main-search").val();

			var data = {"searchBy" : searchBy,"word" : keyWord};
				$.ajax({
					url : "search",
					data : data,
					dataType : "json",
					success : function(data) {
						var tag = "";
						const element = document.getElementById('searchResult');

						if (data.code == 200) {
							$("#result *").remove();
		              		tag = "<h1>추천공고</h1>"
							let list = data.result;   //List Data Get
							for (i = 0; i < list.length; i++) {
 								tag += "<div class = 'recruit'><a href = 'detail/"+list[i].no+"'><div class='container'><img src = '${contextPath}/"+list[i].img+"'><div class = 'comName'><h3>"+list[i].comName+"</h3><h4 class = 'category'>"+list[i].title+"<br>카테고리 : "+list[i].category+"<br>경력 : "+list[i].career+"</h4></div></div></a></div>"
							}
						} else {
							$("#result *").remove();
		               		tag = "<h1>추천공고</h1>"
		                    tag += data.message;
						}
							$('#result').append(tag);
							$("#result").show();
							$(".aa").hide();
						},
					error : function(request,error, status) {
							console.log("code:"+ request.status+ "message:"+ request.responseText+ "error:"+ error);
							}
						});
				});
		});
	</script>
</body>
</html>