<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel='stylesheet' type='text/css' media='screen'
	href='${contextPath}/resources/styles/comAside.css'>
<aside class="comAside" id="comAside">
	<ul class="comAside-menu">
		<li><a href="#">모집 공고</a></li>
		<ul class="comAside-submenu">
			<li><a href="/company/recruitRegist">공고 등록</a></li>
			<li><a href="/company/recruitList">공고 목록</a></li>
		</ul>
	</ul>
	<ul class="comAside-menu">
		<li><a href="#">My Page</a></li>
		<ul class="comAside-submenu">
			<li><a href="#">기업 정보</a></li>
			<li><a href="#">정보 수정</a></li>
		</ul>
	</ul>
	<ul class="comAside-menu">
		<!-- 로그아웃기능 추가하기 -->
		<li><a href="#">LOGOUT</a></li>
	</ul>
	<script src='${contextPath}/resources/scripts/comAside.js'></script>
</aside>