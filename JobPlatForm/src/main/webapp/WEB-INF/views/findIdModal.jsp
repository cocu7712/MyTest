<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="../../resources/css/Bomi/ModalStyle.css" />
<script type="text/javascript">
</script>

<div id="background_modal" class="background_modal"><!-- 기본적인 레이를 backgrouond_modal로 감싼다 -->
	<div class="modal_contesnts">
	<span class="close">&times;</span>
		<h4>고객님의 아이디는  </h4>
		<br>
		<h3 id="id_value" style="text-align:center" ></h3>
		<br>
		<div style="display:flex;justify-content:center;align-items:center;">
		<button style="" type="button" id="findpw_btn" class="btn" onclick="location.href='/findPw'">
		<i class="fa fa-envelope"></i>비밀번호 찾기</button>
		</div>
</div>
</div>
