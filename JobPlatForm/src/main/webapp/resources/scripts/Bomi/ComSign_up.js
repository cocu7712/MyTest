/**
 * 
 */
function ComSign_up(){
	var company_email = document.getElementById("company_email");
    var company_pw = document.getElementById("company_pw");
    var company_password_chk = document.getElementById("company_password_chk");
    var company_name = document.getElementById("company_name");
    var company_roadAddr = document.getElementById("company_roadAddr");
    var company_addrDetail = document.getElementById("company_addrDetail");
    var company_tel = document.getElementById("company_tel");
	var company_img = document.getElementById("company_img");
	var email = company_email.value;
	var pw = company_pw.value;
	var tel = company_tel.value;
    //공백 유효성 검사
    if(!company_email.value){
        alert("이메일를 입력하세요");
        company_email.focus();
        return false;
    }else if(email.search(/\s/) != -1){
	    alert("이메일은 공백 없이 입력해주세요.");
	    company_password.focus();
    	return false;
	}
	var regExp = /^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i;
	if (email.match(regExp) == null) {
		alert("올바른 이메일을 입력해주세요");
        company_email.focus();
		return false;
	}
	
    if(!company_pw.value){
        alert("비밀번호를 입력하세요");
        company_pw.focus();
        return false;
    }
    if(!company_password_chk.value){
        alert("비밀번호 확인을 입력하세요");
        company_password_chk.focus();
        return false;
    }
    
    if(company_pw.value != company_password_chk.value){
    	alert("비밀번호가 일치하지 않습니다");
        company_password_chk.focus();
   		return false;
    }else if(pw.search(/\s/) != -1){
	    alert("비밀번호는 공백 없이 입력해주세요.");
	    company_pw.focus();
    	return false;
	}
    //비밀번호 10자리 이상 확인
	if(pw.length < 10){
		alert("비밀번호 10자리 이상 입력해주세요");
        company_password_chk.focus();
    	return false;
    }
    
    if(!company_name.value){
        alert("기업명을 입력하세요");
        company_name.focus();
        return false;
    }
        
    if(!company_roadAddr.value){
        alert("도로명 주소를 입력하세요");
        company_roadAddr.focus();
        return false;
    }
    if(!company_addrDetail.value){
        alert("상세주소를 입력하세요");
        company_addrDetail.focus();
        return false;
    }

	if(!company_tel.value){
        alert("연락처를 입력하세요");
        company_tel.focus();
        return false;
    }
    if(tel.length > 11 || tel.length < 10){
    	alert("연락처를 다시 입력해주세요");
    	company_tel.focus();
    	return false;
    } 

	if(!company_img.value){
        alert("기업 이미지를 선택하세요");
        company_img.focus();
        return false;
    }

	new_company.submit();
}