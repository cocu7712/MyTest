<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../shopage/shoppingTop.jsp"%>

<body>
<form method="post" name="join" action="memberShipJoinPro.jsp">
<table class="memberShipJoin_table">
	<caption><h2>회원가입</h2></caption>
	<tr>
		<td class="memberShipJoin_td1">이름<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2">
			<input class="memberShipJoin_inputText" type="text" size="35" name="name" maxlength="20">
		</td>
		<td class="memberShipJoin_td3"><div style="color: red; float: left; font-size:12px ">이름은 한글,영문으로만 입력 가능합니다.</div></td>
	</tr>
	<tr>
		<td class="memberShipJoin_td1" height="100">아이디 (이메일))<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2" colspan="2">
			<input class="memberShipJoin_inputText" type="text" size="35" name="email1" maxlength="20">@
			<select name="email2" size="1">
				<option value="naver.com">naver.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="nate.com">nate.com</option>
				<option value="yahoo.co.kr">yahoo.co.kr</option>
				<option value="gmail.com">gmail.com</option>
			</select>
			<input class="memberShipJoin_inputButton" type="button" name="botton" value="이메일 중복 확인" style="background-color:#f9f9f9;">
			<p style="font-size: 10px; color: gray;">
			* 2012년 8월 18일 부터 시행되는 「정보통신망 이용 촉진 및 정보 보호 등에 관한 법률 (이하 정보통신망법)」 제 23조의 "주민등록번호의 사용 제한"에 따라 유니클로 온라인 스토어는 주민등록번호를 수집 및 이용하지 않습니다.
			 이에 따라 유니클로 온라인 스토어의 회원으로 가입하실 때는 주민등록번호를 입력하는 실명인증 대신 이메일을 이용하여 본인인증을 하셔야 합니다.
			</p>
		</td>
	</tr>
	<tr>
		<td class="memberShipJoin_td1">비밀번호<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2">
			<input class="memberShipJoin_inputText" type="password" size="35" name="passwd" maxlength="20">
		</td>
		<td class="memberShipJoin_td3" rowspan="2" style="background-color: #f9f9f9;">
		<p style="font-size: 9px;">
		*영문, 숫자, 특수문자 중 2종류 이상을 조합하여 최소 10자리 이상 또는 3종류 이상을 조합하여 최소 8자리 이상으로 설정해 주세요.<br>
		아이디(이메일)과 같거나 유사해서는 안됩니다.<br>
		*단일 문자열, 연속 문자열 등 쉬운 비밀번호는 안됩니다.<br>
		*연속하여 3자리 이상의 숫자를 입력할 수 없습니다. (예: love333)<br>
		*기타 일반 정보 등으로부터 추측이 용이한 비밀번호는 피해주세요.<br>
		*타사 서비스에서 사용하는 비밀번호와 동일한 비밀번호를 사용하지 마십시오.
		</p>
		</td>
	</tr>
	<tr>
		<td class="memberShipJoin_td1">비밀번호 확인<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2">
			<input class="memberShipJoin_inputText" type="password" size="35" name="repasswd" maxlength="20">
		</td>
	</tr>
	<tr>
		<td class="memberShipJoin_td1">휴대폰<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2">
		<select name="tel1" style="margin-left: 10">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
		</select>
		-<input type="text" name="tel2" size="4" maxlength="4">
		-<input type="text" name="tel3" size="4" maxlength="4"> 
		</td>
		<td class="memberShipJoin_td3" ></td>
	</tr>
	<tr>
		<td class="memberShipJoin_td1">개인정보 보관 기간 설정<div style="color: red; float: left;">*</div> </td>
		<td class="memberShipJoin_td2">
			1년<input type="radio" checked="checked">
			3년<input type="radio">
		</td>
		<td class="memberShipJoin_td3"></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
			<input type="button" value="동의하고 회원가입 요청" onclick="passwdCheck(this.form)">
		</td>
	</tr>
</table>
</form>
</body>

<%@include file="../shopage/shoppingFooter.jsp"%>