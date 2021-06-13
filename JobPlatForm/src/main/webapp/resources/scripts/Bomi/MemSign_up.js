/**
 * 
 */
 //일반회원 step1 유효성 검사
 function MemSign_up_step1(){
    var member_email = document.getElementById("member_email");
    var member_pw = document.getElementById("member_pw");
    var member_password_chk = document.getElementById("member_password_chk");
    var email = member_email.value;
    var pw = member_pw.value;
    
    
    //공백 유효성 검사
    if(!member_email.value){
        alert("이메일를 입력하세요");
        member_email.focus();
        return false;
    }else if(email.search(/\s/) != -1){
	    alert("이메일은 공백 없이 입력해주세요.");
	    member_password.focus();
    	return false;
	}
	
    if(!member_pw.value){
        alert("비밀번호를 입력하세요");
        member_pw.focus();
        return false;
    }
    if(!member_password_chk.value){
        alert("비밀번호 확인을 입력하세요");
        member_password_chk.focus();
        return false;
    }
    
    //비밀번호 + 비밀번호 확인 체크(제이쿼리) + js
    if(member_pw.value != member_password_chk.value){
    	alert("비밀번호가 일치하지 않습니다");
        member_password_chk.focus();
   		return false;
    }else if(pw.search(/\s/) != -1){
	    alert("비밀번호는 공백 없이 입력해주세요.");
	    member_pw.focus();
    	return false;
	}
	
    //비밀번호 10자리 이상 확인
	if(pw.length < 10){
		alert("비밀번호 10자리 이상 입력해주세요");
        member_password_chk.focus();
    	return false;
    }
    
	var regExp = /^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i;
	if (email.match(regExp) == null) {
		alert("올바른 이메일을 입력해주세요");
        member_email.focus();
		return false;
	}
			
    //위 유효성 검사 모두 통과시
    $(".signUpStep1Con").attr("style", "display:none");
    $(".signUpStep2Con").attr("style", "display:show");
}
//일반회원 step2 유효성 검사
function MemSign_up_step2(){
	var member_name = document.getElementById("member_name");
    var member_phone = document.getElementById("member_phone");
    var member_roadAddr = document.getElementById("member_roadAddr");
    var member_addrDetail = document.getElementById("member_addrDetail");
    var phone = member_phone.value;
    if(!member_name.value){
        alert("이름을 입력하세요");
        member_name.focus();
        return false;
    }
    if(!member_phone.value){
        alert("핸드폰번호를 입력하세요");
        member_phone.focus();
        return false;
    }
    if(phone.length != 11){
    	alert("핸드폰번호를 다시 입력해주세요");
    	member_phone.focus();
    	return false;
    } 
    
    if(!member_roadAddr.value){
        alert("도로명 주소를 입력하세요");
        member_roadAddr.focus();
        return false;
    }
    if(!member_addrDetail.value){
        alert("상세주소를 입력하세요");
        member_addrDetail.focus();
        return false;
    }
	
	
	new_member.submit(); //form 식별을 위한 name
}