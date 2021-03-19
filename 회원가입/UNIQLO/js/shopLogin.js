
function loginWindow() {
	window.open("../login/login.jsp","loginWindow","width=500, height=500, left=100, top=50");
}

function passwdCheck(join) {
	
	if(!join.name.value){
		alert("아이디를 입력하세요");
		join.name.focus();
		 return false;
	}

	if(!join.email1.value){
		alert("이메일을 입력하세요");
		join.email1.focus();
		return false;
	}
	
	if(!join.passwd.value || !join.repasswd.value){
		alert("패스워드를 입력하세요");
		join.passwd.focus();
		return false;
	}
	
	if(!join.tel2.value){
		alert("전화번호를 입력하세요");
		join.tel2.focus();
		return false;
	}
	if(!join.tel3.value){
		alert("전화번호를 입력하세요");
		join.tel3.focus();
		return false;
	}
	
	if(join.passwd.value != join.repasswd.value){
		alert("입력한 패스워드가 다릅니다");
		join.passwd.focus();
		return false;
	}
	
	join.action = "memberShipJoinPro.jsp";
	join.submit();
}


function userDataCheck(join) {
	
	if(!join.name.value){
		alert("아이디를 입력하세요");
		join.name.focus();
		return false;
	}
	
	if(!join.email1.value){
		alert("이메일을 입력하세요");
		join.email1.focus();
		return false;
	}
	
	if(!join.passwd.value){
		alert("패스워드를 입력하세요");
		join.passwd.focus();
		return false;
	}
	
	
	if(!join.updataPasswd.value){
		alert("변경할 패스워드를 입력하세요");
		join.updataPasswd.focus();
		return false;
	}
	
	
	if(!join.tel2.value){
		alert("전화번호를 입력하세요");
		join.tel2.focus();
		return false;
	}
	
	if(!join.tel3.value){
		alert("전화번호를 입력하세요");
		join.tel3.focus();
		return false;
	}
	
	if(join.passwd.value != join.DBpasswd.value){
		alert("패스워드가 다릅니다 다시 입력하세요");
		join.passwd.focus();
		return false;
	}
	
	join.action="../member/updatePro.jsp";
	join.submit();
}

