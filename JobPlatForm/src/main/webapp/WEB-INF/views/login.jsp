<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
	<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <link rel="stylesheet" href="${contextPath}/resources/styles/Bomi/Login.css">
  <title>로그인</title>
  <script>
  	$(function () {
    	//카카오 라이브러리 초기화
        Kakao.init('6bc44243d7c9eba5b8a16b6e340bc3b4');
        console.log(Kakao.isInitialized());//초기화 여부
       // $("#unlink").click(unlinkApp);
       //$("#logout").click(kakaoLogout);
       
        $("#member").click(function () {
            $("#member").attr("class", "tab_item on");
            $("#company").attr("class", "tab_item");
            $(".company").attr("style", "display:none");
            $(".member").attr("style", "display:show");
            //alert("일반회원");
        });

        $("#company").click(function () {
            $("#member").attr("class", "tab_item");
            $("#company").attr("class", "tab_item on");
            $(".member").attr("style", "display:none");
            $(".company").attr("style", "display:show");
            //alert("기업회원");
        });  
   
       
  	});
      //카카오 로그인2
        function getProfile(){
            Kakao.API.request({
                url: '/v2/user/me',
                success: function(res) {
                  console.log(res); 
                  $('#kakao_email').val(res.kakao_account.email);
                  //$('#memberlogin').attr('action','/LoginOK').submit();
	           	  $("#Member").submit();
                },
                fail: function(error) {
                  console.log(
                      JSON.stringify(error)
                  )
                },
              });
        }
        //카카오로그인1
        function loginWithKakao() {
            Kakao.Auth.login({
                success: function (authObj) {
                    console.log(JSON.stringify(authObj))
                    getProfile();
                },
                fail: function (err) {
                    console.log(JSON.stringify(err))
                },
            })
        }
        
       function loginchk(){
    	   var member_email = document.getElementById("member_email");
    	   var member_pw = document.getElementById("member_pw");
    	   
    	   if(!member_email.value){
    	        alert("이메일를 입력하세요");
    	        member_email.focus();
    	        return false;
    	    }
    	   if(!member_pw.value){
    	        alert("비밀번호를 입력하세요");
    	        member_pw.focus();
    	        return false;
    	    }
    	   //document.member.submit();
    	   $("#Member").submit();
       }
       
       function loginchkcom(){
    	   var company_email = document.getElementById("company_email");
    	   var company_pw = document.getElementById("company_pw");
    	   
    	   if(!company_email.value){
    	        alert("이메일를 입력하세요");
    	        company_email.focus();
    	        return false;
    	    }
    	   if(!company_pw.value){
    	        alert("비밀번호를 입력하세요");
    	        company_pw.focus();
    	        return false;
    	    }
    	   //document.member.submit();
    	   $("#Company").submit();
       }
  
  </script>
  <style>
li > a {
  width: 100%;
  text-align: center;
  display: inline-block;
  text-decoration: none;
  font-size: 16px;
  font-weight: 700;
}

li {
  display: inline-block;
  cursor: pointer;
  padding: 10px 0px;
}

ul {
  font-size: 0px;
  text-align: center;
  padding: 0;
}  
.tab_item.on {
  background-color: lightgray;
  border-color: lightgray;
  text-decoration: none;
  font-weight: 700;
}
.tab_item {
  border: 1px solid lightgray;
  box-sizing: border-box;
  width: 150px;
  font-size: 16px;
  border-radius: 2px;
  margin-bottom: 10px;
}
  
  </style>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <div class="header"></div>
    <div class="left"></div>
    <div class="right"></div>
    <div class="section">
        <div class="content">
            <div class="margin">
                <h2> 로그인 </h2>
                
                <div class="signup_box">
	            	<ul>
	           			<li id="member" class="tab_item on"><a>개인회원</a></li>
	         			<li id="company" class="tab_item"><a>기업회원</a></li>
	               </ul>
	            </div>
                
	            <div class="member">
	                <div id="kakaologin">
	                    <p class="text">카카오톡으로 바로 로그인 하기</p>
	                    <div class="br"></div>
	                    <a class="btn kakaologin" href="javascript:loginWithKakao();"><img class="kakao_login_img"
	                            src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"></a>
	                </div>
	                <br>
	                <div class="hr-sect">또는</div><br>
	                <form name="Member" id="Member" action="/LoginOK" method="post">
		                <div id="memberlogin">
		                    <input type="text" id="member_email" name="mem_email" placeholder="이메일">
		                    <input type="hidden" id="kakao_email" name="kakao_email" value="">
		                    <div class="br"></div>
		                    <input type="password" id="member_pw" name="mem_password" placeholder="비밀번호">
		                    <button type="button" class="btn memberlogin" onclick="loginchk();" >로그인</button>
		                </div>
	                </form>
                </div>
                <div class="company" style="display:none">
                	<form name="Company" id="Company" action="/ComSignOK" method="post">
		                <div id="memberlogin">
		                    <input type="text" id="company_email" name="com_email" placeholder="이메일">
		                    <div class="br"></div>
		                    <input type="password" id="company_pw" name="com_password" placeholder="비밀번호">
		                    <button type="button" class="btn memberlogin" onclick="loginchkcom();" >기업 로그인</button>
		                </div>
	                </form>
                
                </div>
                
                <div class="utilMenu">
                    <a class="select_id" href="/findId">아이디 찾기</a><a class="right" href="/Sign_up">가입하기</a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
<jsp:include page="include/footer.jsp"/>
</body>
</html>