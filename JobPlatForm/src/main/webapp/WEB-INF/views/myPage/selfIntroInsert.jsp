<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
        </div>
        <form action="/myPage/selfIntroInsert" method="post">
         <h2>제목</h2>
         <input class="title" type="text" name="title">
         <h2>지원동기</h2>
         <textarea class="textarea" name="intro_text1" id="intro_text1" rows="12"></textarea>
        <h2>성장과정</h2>
        <textarea class="textarea" name="intro_text2" id="intro_text2" rows="12"></textarea>
        <h2>성격 장단점</h2>
        <textarea class="textarea" name="intro_text3" id="intro_text3" rows="12"></textarea>
        <h2>입사후 포부</h2>
        <textarea class="textarea" name="intro_text4" id="intro_text4" rows="12"></textarea>
        <div class="div-submit">
          <input class="submit" type="submit" value="작성완료">
        </div>
      </form>
      </article>
    </div>
  </section>
  <jsp:include page="../include/footer.jsp"/>
</body>
</html>