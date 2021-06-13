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
	href='${contextPath}/resources/styles/myPageSelfIntro.css'>
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
        <div class="select">
          <select onchange="window.open(value,'_self');" name="select" id="select">
          		<option value="">자소서를 선택하세요</option>
          	<c:forEach var="items" items="${selfIntrolist}">
          		<option value="http://localhost:9999/myPage/selfIntro?no=${items.introNo}">${items.title}${items.introNo}</option>
          	</c:forEach>
          </select>
        </div>
        <h2>지원동기</h2>
        <textarea class="textarea" value="" name="" id="textarea1" rows="12"  readonly>${selfIntroDto.intro_text1}</textarea>
        <h2>성장과정</h2>
        <textarea class="textarea" name="" id="textarea2" rows="12" readonly>${selfIntroDto.intro_text2 }</textarea>
        <h2>성격 장단점</h2>
        <textarea class="textarea" name="" id="textarea3" rows="12" readonly>${selfIntroDto.intro_text3 }</textarea>
        <h2>입사후 포부</h2>
        <textarea class="textarea" name="" id="textarea4" rows="12" readonly>${selfIntroDto.intro_text4 }</textarea>
        <div class="div-button">
          <form action="/myPage/selfIntroUpdate">
          	<input type="hidden" name="no" value="${selfIntroDto.introNo}">
          	<input class="inputButton" type="submit" value="수정하기">
          </form>
        </div>
      </article>
    </div>
  </section>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>