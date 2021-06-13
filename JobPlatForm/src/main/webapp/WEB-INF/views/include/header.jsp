 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <link rel='stylesheet' type='text/css' media='screen' href='${contextPath}/resources/styles/header-nav.css'>
 <header class="header">
   <nav id="nav">
     <ul class="left">
        <li><a href="/main" class="left-logo"> Ko It Job</a></li>
        <li id="nav-menubar"><img class="nav-img" src="${contextPath}/resources/images/btn_change.png"></li>
     </ul>
     <ul class="right" id="nav-right">
     <c:choose>
      <c:when test="${not empty member}">
       <li><a href="/myPage/resume"> 마이페이지</a></li>
      </c:when>
      <c:when test="${not empty company}">
       <li><a href="#"> 기업관리</a></li>
      </c:when>
      <c:otherwise>
       <li><a href="/Login"> 로그인</a></li>
      </c:otherwise>
     </c:choose>
     <c:if test="${empty member && empty company}">
       <li><a href="/Sign_up"> 회원가입</a></li>
     </c:if>
       <li><a href="#"> 인적성검사</a></li>
       <li><a href="#" id="nav-right-last" class="last"> 추천</a></li>
     </ul>
    </nav>
 <script src='${contextPath}/resources/scripts/header-nav.js'></script>
 </header>