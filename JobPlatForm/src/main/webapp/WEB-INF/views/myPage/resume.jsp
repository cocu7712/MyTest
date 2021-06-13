<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>팀플 메인</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/myPageResume.css'>
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/jquery-ui.min.css'>
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
<script src="${contextPath}/resources/libs/jquery-ui/jquery-ui.min.js"></script>
<style type="text/css">
.ui-icon, .ui-widget-content .ui-icon {
    background-image: url(/resources/images/ui-icons_444444_256x240.png);
}
</style>
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
      <article class="myPageMenu-resume">
        <h1>이력서 관리</h1>
        <div class="top">
          <div class="img"></div>
          <div class="member">
            <ul>
              <li><div>Name</div><input type="text" name="name" value="${member.mem_name}" readonly></li>
              <li><div>Sex</div><input type="text" name="sex" value="${member.mem_sex}" readonly></li><br>
              <li><div>Birth</div> <input type="text" name="birth" value="${member.mem_birth}" readonly></li>
              <li><div>Phone</div> <input type="text" name="phone" value="${member.mem_phone}" readonly></li><br>
              <li><div>Email</div> <input type="text" name="Email" value="${member.mem_useremail}" readonly></li><br>
              </li>
                <br>
              <li><div>Address</div> <input class="address" type="text" name="address" value="${member.mem_roadAddr}" readonly></li><br>
              <li><div>Address Line2</div> <input class="address" type="text" name="address2" value="${member.mem_addrDetail}" readonly></li>
            </ul>

          </div>
        </div>
        <div class="body">
          <h2>학교</h2>
          <ul>
          	<li class="ShcoolInsert">
          	<form id="insert-school">
          		<select name="school">
          			<option>중학교</option>
          			<option>고등학교</option>
          			<option>대학교</option>
          			<option>대학원</option>
          		</select>
          		<input class="input-size1" id="schoolDetail" type="text" name="schoolDetail" placeholder="대학교를 입력해주세요(최대 12자)">
          		<input class="input-size2" id="admission" type="date" name="admission">
          		<input class="input-size2" id="graduated" type="date" name="graduated">
          		<button id="insert-school-button">등록</button>
          	</form>
          	</li>
          	<li id="schoolText">
          		<div class="size1">학력</div>
          		<div class="size2">학교</div>
          		<div class="size1">입학</div>
          		<div class="size1">졸업(예정)</div>
          		</li>
          	<li id="school-box" class="school-box">
          		<div class="school"></div>
          		<div class="schoolDetail"></div>
          		<div class="admission"></div>
          		<div class="graduated"></div>
          		<button id="deleteSchool" class="delete"><img class="text" src="${contextPath}/resources/images/redDelete.png"/></button>
          		<!--  <img class="text" src="${contextPath}/resources/images/redDelete.png"/> -->
          	</li>
          </ul>
           <h2>경력사항</h2>
          <ul>
          	<li class="career">
          	<form id="insert-career">
          		<input class="input-size4" id="position" type="text" name="position" placeholder="직무">
          		<input class="input-size1" id="company" type="text" name="company" placeholder="회사">
          		<input class="input-size2" id="startDate" type="text" name="startDate">
          		<input class="input-size2" id="endDate" type="text" name="endDate">
          		<button id="insert-career-button">등록</button>
          	</form>
          	</li>
          	<li id="careerText">
          		<div class="size1">직무</div>
          		<div class="size2">회사(학원)</div>
          		<div class="size1">입사</div>
          		<div class="size1">퇴사</div>
          	</li>
          	<li id="career-box" class="career-box">
          		<div class="position"></div>
          		<div class="company"></div>
          		<div class="startDate"></div>
          		<div class="endDate"></div>
          		<button id="deleteCareer" class="delete"><img class="text" src="${contextPath}/resources/images/redDelete.png"/></button>
          		<!--  <img class="text" src="${contextPath}/resources/images/redDelete.png"/> -->
          		
          	</li>
          </ul>
          <h2>자격증</h2>
          <ul>
          	<li class="certificateInsert">
          	<form id="insert-certificate">
          		<input class="input-size3" id="certificate" type="text" name="certificate" placeholder="자격증 이름">
          		<input class="input-size1" id="issuer" type="text" name="issuer" placeholder="발급처">
          		<input class="input-size2" id="getDate" type="date" name="getDate" placeholder="발급일">
          		<button id="insert-certificate-button">등록</button>
          	</form>
          	</li>
          	<li id="certificateText">
          		<div class="size2">자격증</div>
          		<div class="size2">발급처</div>
          		<div class="size1">발급일</div>
          	</li>
          	<li id="certificate-box" class="certificate-box">
          		<div class="certificate"></div>
          		<div class="issuer"></div>
          		<div class="getDate"></div>
          		<button id="deleteCertificate" class="delete-c"><img class="text" src="${contextPath}/resources/images/redDelete.png"/></button>
          		<!--  <img class="text" src="${contextPath}/resources/images/redDelete.png"/> -->
          	</li>
          </ul>
        </div>
      </article>
    </div>
  </section>
  <jsp:include page="../include/footer.jsp"/>
  <script src="${contextPath}/resources/scripts/resume.js"></script>
</body>
</html>