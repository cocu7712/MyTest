<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/Top.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/shopLogin.js"></script>
<title>유니클로 온라인 스토어</title>
</head>

<%
String id = "";

	try{
		
	id = (String)session.getAttribute("id");
	
	if(id == null || id.equals("")){
	%>

<header style="width: 1900px;">
	<div class="div_top_img">
		<a class="img_logo_size" href="../index.jsp"><img src="https://simage-kr.uniqlo.com/nq/img/logo_2021.svg"></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">WOMEN</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">MEN</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">KIDS</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">BABY</h5></a>
	</div>
	
	<div class="div_top_menu2_start">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_company.svg"><br>COMPANY</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_store.svg"><br>매장안내</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_cscenter.svg"><br>고객센터</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="#" onclick="loginWindow();">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_login.svg"><br>로그인</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../login/memberShipJoin.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_join.svg"><br>회원가입</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_basket.svg"><br>장바구니</a>
	</div>
	<div class="div_top_search">
	<form action="../index.jsp" method="get">
		<input class="Top_serch_text" size="30" type="text" name="serch" placeholder="키워드로 검색 (예)히트텍">
		<button class="Top_search_img">
			<img src="https://simage-kr.uniqlo.com/nq/img/btn_gnav_search.svg">
		</button>
	</form>
	</div>
	
	<div class="div_top_hr">
	<br>
	<hr width="100%" style="margin-top: 10px">
	</div>
</header>
<%}else{ %>
<header style="width: 1900px;">
	<div class="div_top_img">
		<a class="img_logo_size" href="../index.jsp"><img src="https://simage-kr.uniqlo.com/nq/img/logo_2021.svg"></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">WOMEN</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">MEN</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">KIDS</h5></a>
	</div>
	<div class="div_top_menu1">
		<a class="a_top_menu" href="../index.jsp"><h5 class="h5_top_menu">BABY</h5></a>
	</div>
	
	<div class="div_top_menu2_start">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_company.svg"><br>COMPANY</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_store.svg"><br>매장안내</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_cscenter.svg"><br>고객센터</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../member/updateForm.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_login.svg"><br>나의 정보</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../index.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_basket.svg"><br>장바구니</a>
	</div>
	<div class="div_top_menu2">
		<a class="a_top_menu2" href="../login/logout.jsp">
		<img src="https://simage-kr.uniqlo.com/nq/img/ico_gutil_join.svg"><br>로그아웃</a>
	</div>
	<div class="div_top_search">
	<form action="../index.jsp" method="get">
		<input class="Top_serch_text" size="30" type="text" name="serch" placeholder="키워드로 검색 (예)히트텍">
		<button class="Top_search_img">
			<img src="https://simage-kr.uniqlo.com/nq/img/btn_gnav_search.svg">
		</button>
	</form>
	</div>
	
	<div class="div_top_hr">
	<br>
	<hr width="100%" style="margin-top: 10px">
	</div>
</header>
<%}
}catch(Exception e){
	e.printStackTrace();
}
%>