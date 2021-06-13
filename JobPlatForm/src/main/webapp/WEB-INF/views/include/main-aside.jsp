<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' type='text/css' media='screen' href='${contextPath}/resources/styles/main-aside.css'>
<aside class="main-aside" id="main-aside">
    <ul class="main-aside-menu">
      <li><a href="/recruit/All"> 모집 공고</a></li>
      <ul class="main-aside-submenu">
        <li><a href="/recruit/웹 개발">웹 개발</a></li>
        <li><a href="/recruit/모바일">모바일</a></li>
        <li><a href="/recruit/빅데이터">빅데이터</a></li>
        <li><a href="/recruit/DB">DB</a></li>
      </ul>
    </ul>
    <c:choose>
    <c:when test="${not empty member}">
    <ul class="main-aside-menu">
      <li><a href="#">My Page</a></li>
      <ul class="main-aside-submenu">
        <li><a href="#">개인정보</a></li>
        <li><a href="/myPage/resume">이력서</a></li>
        <li><a href="/myPage/selfIntroList">자기소개서</a></li>
        <li><a href="#">관심공고</a></li>
        <li><a href="#">지원회사</a></li>
      </ul>
    </ul>
    </c:when>
    <c:when test="${not empty company}">
    <ul class="main-aside-menu">
      <li><a href="#">Com Page</a></li>
      <ul class="main-aside-submenu">
        <li><a href="#">기업정보</a></li>
        <li><a href="#">공고관리</a></li>
        <li><a href="#">기업탈퇴</a></li>
      </ul>
    </ul>
    </c:when>
    <c:otherwise>
    <ul class="main-aside-menu">
      <li><a href="/Sign_up">회원가입</a></li>
    </ul>
    </c:otherwise>
    </c:choose>
    <ul class="main-aside-menu">
    <c:choose>
    	<c:when test="${not empty member || not empty company }">
 	     <li><a href="/logout">Logout</a></li>
    	</c:when>
    	<c:otherwise>
 	     <li><a href="/Login">Login</a></li>
    	</c:otherwise>
    </c:choose>
    </ul>
    <script src='${contextPath}/resources/scripts/main-aside.js'></script>
  </aside>