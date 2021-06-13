<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>팀플 메인</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/myPageSelfList.css'>
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/main-aside.jsp"/>
  <section class="myPage">
    <div class="myPagebox">
      <article class="myPageMenu">
        <h2>개인 회원</h2>
        <hr>
        <ul>
          <h3>회원정보 관리</h3>
          <li><a href="#">개인정보</a> </li>
          <li><a href="#">개인정보 수정</a> </li>
          <li><a href="#">비밀번호 찾기</a> </li>
          <li><a href="#">회원탈퇴</a> </li>
        </ul>
        <hr>
        <ul>
          <h3>취업 관리</h3>
          <li><a href="/myPage/resume">이력서 관리</a> </li>
          <li><a href="/myPage/selfIntroList">자기소개서 관리</a> </li>
        </ul>
        <hr>
        <ul>
          <h3>지원관리</h3>
          <li><a href="#">지원회사</a> </li>
          <li><a href="#">관심기업</a> </li>
        </ul>
      </article>
      <article class="selfIntro">
        <h1>자기소개서</h1>
        <div class="list">
        	<div class="height"></div>
        	<c:forEach var="items" items="${selfIntrolist}" varStatus="i">
        	<ul>
        		<li class="li1">${i.count}</li>
        		<li class="li2"><a href="/myPage/selfIntro?no=${items.introNo}">&nbsp;${items.title}</a></li>
        		<li class="li3">
        		<!-- 
        		<form action="/myPage/selfIntroDelete" method="post">
        		<input type="hidden" name="no" value="${items.introNo}">
        			<input type="submit" value="Delete" id="delete">
        		</form>
        		 -->
        		 <button id="delete" class="delete" value="${items.introNo}">delete</button>
        		</li>
        	</ul>
        	</c:forEach>
        	<div class="div-button">
        		<button><a href="/myPage/selfIntroInsert">작성하기</a></button>
        	</div>
        </div>
      </article>
    </div>
  </section>
  <jsp:include page="../include/footer.jsp"/>
  <script src="${contextPath}/resources/scripts/selfIntroList.js"></script>
</body>
</html>