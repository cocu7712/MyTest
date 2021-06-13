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

	<h2>모집 공고 등록</h2>

	<section class="Regist_Info">
		<form class="RecruitmentField" action = "recruitRegist" method = "post">
			<b>모집 분야</b>
			<select name="category">
				<option value="카테고리선택" selected="selected">카테고리선택</option>
				<option value="웹 개발">웹 개발</option>
				<option value="모바일">모바일</option>
				<option value="빅데이터">빅데이터</option>
				<option value="DB">DB</option>
			</select>
			<br>
			<br>
			<b>공고 제목</b>
			<input type="text" name="recruitTitle" class="Regist_Title">
			<input type="text" class="RegistNumber"> 명 모집</input>
			<br>
			<br>
			<b>경력 여부</b>
			<span><input type="checkbox" name="career" value="신입">신입</span>
			<span><input type="checkbox" name="career" value="경력">경력</span>
			<span><input type="checkbox" name="career" value="경력무관">경력무관</span>
			<br>
			<br>
			<b>태그</b>
			<span><input type="checkbox" name="cbTag" value="java">java</span>
			<span><input type="checkbox" name="cbTag" value="C/C++">C/C++</span>
			<span><input type="checkbox" name="cbTag" value="python">python</span>
     	 	<span><input type="checkbox" name="cbTag" value="javascript">javascript</span>
     		<span><input type="checkbox" name="cbTag" value="spring">spring</span>
      		<span><input type="checkbox" name="cbTag" value="프론트엔드">프론트엔드</span>
      		<span><input type="checkbox" name="cbTag" value="백엔드">백엔드</span>
      		<span><input type="checkbox" name="cbTag" value="Oracle">Oracle</span>
      		<span><input type="checkbox" name="cbTag" value="MYSQL">MYSQL</span>
			<br>
			<br>
			<b>담당 업무</b>
			<input type="text" name="Text1" class="Recruit_Text1">
			<br>
			<br>
			<b>전형 절차</b>
			<input type="text" name="Text2" class="Recruit_Text2">
			<br>
			<br>
			<b>모집 기간</b>
			<input type="text" name="Text3" class="Recruit_Text3">
			<br>
			<br>
		    <div class="CompanyIntro">
					<b>기업 소개</b>
					<textarea name="Text4" class="Recruit_Text4" rows="10" cols="100" wrap="virtual">원하시는 내용을 입력 해 주세요.</textarea>
		    </div>
			<br>
			<br>
			<b>유의 사항</b>
			<input type="text" name="Text5" class="Recruit_Text5">
		    <div class="buttons">
		      <input type="submit" value="등록" class="Regist">
		      <input type="button" value="취소" class="Cancel" onclick="history.back(-1);">
		    </div>
		</form>
  
	</section>

	<div>
		<jsp:include page="../include/footer.jsp" />
	</div>
</body>

</html>