<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.db.recruit.RecruitDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>팀플 메인</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
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
	</section>
	<%
		RecruitDto a = (RecruitDto)session.getAttribute("recruit");
		String img = a.getImg();
		String title = a.getTitle();
		String comName = a.getComName();
		String category = a.getCategory();
		String tel = a.getTel();
		String fax = a.getFax();
		String address = a.getRoadAddr();
		String text1 = a.getText1();
		String text2 = a.getText2();
		String text3 = a.getText3();
		String text4 = a.getText4();
		String text5 = a.getText5();
	%>
	<div class = "recruit_detail">
							<div class="img_box">
								<img src="${contextPath}/<%=img%>">
							</div>
							<div class = "comInfo">
							<h1>기업 명 : <%=comName %></h1>
							<h2>지원 분야 : <%=category %></h2>
							<h3>
							<c:forEach var = "tag" items = "${tag}" varStatus = "i">
								#${tag.tag}
							</c:forEach>
							</h3><hr>
							</div>
							<span>모집 분야 : </span>
							<span><%=text1 %></span><hr>
							<span>모집 절차 : </span>
							<span><%=text2 %></span><hr>
							<span>모집 기간 : </span>
							<span><%=text3 %></span><hr>
							<span>유의 사항 : </span>
							<span><%=text5 %></span><hr>
	<a href = "javascript:popup();">지원하기</a>
	</div>
	
	<div>
		<jsp:include page="../include/footer.jsp" />
	</div>
	<script>
	  function popup(){
            var url = "/selectTitle";
            var name = "지원하기";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no"
            window.open(url, name, option); 
            
            
        }
    </script>
</body>
</html>