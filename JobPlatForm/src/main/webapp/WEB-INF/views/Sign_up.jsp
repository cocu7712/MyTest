<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="${contextPath}/resources/libs/jquery-3.6.0.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="${contextPath}/resources/scripts/Bomi/MemSign_up.js"></script>
<script src="${contextPath}/resources/scripts/Bomi/ComSign_up.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/styles/Bomi/MainSign_up.css">
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
            
            
            $('#member_pw').keyup(function () {
                  if ($('#member_pw').val() != $('#member_password_chk').val()) {
                	  $('#member_pw').css('border', '2px solid red');
                      $('#member_password_chk').css('border', '2px solid red');
                      $('.pwchk').html('비밀번호 일치하지 않음');
                      $('.pwchk').css('color', 'red');
                  } else {
                	  $('#member_pw').css('border', '1px solid lightgray');
                      $('#member_password_chk').css('border', '1px solid lightgray');
                      $('.pwchk').html('');
                  }
            });
			$('#member_password_chk').keyup(function () {
                if ($('#member_pw').val() != $('#member_password_chk').val()) {
                    $('#member_pw').css('border', '2px solid red');
                    $('#member_password_chk').css('border', '2px solid red');
                    $('.pwchk').html('비밀번호 일치하지 않음');
                    $('.pwchk').css('color', 'red');
                } else {
                	$('#member_pw').css('border', '1px solid lightgray');
                    $('#member_password_chk').css('border', '1px solid lightgray');
                    $('.pwchk').html('');
                  }
             });
			
            $('#company_pw').keyup(function () {
                if ($('#company_pw').val() != $('#company_password_chk').val()) {
              	  $('#company_pw').css('border', '2px solid red');
                    $('#company_password_chk').css('border', '2px solid red');
                    $('.compwchk').html('비밀번호 일치하지 않음');
                    $('.compwchk').css('color', 'red');
                } else {
              	  $('#company_pw').css('border', '1px solid lightgray');
                    $('#company_password_chk').css('border', '1px solid lightgray');
                    $('.compwchk').html('');
                }
          });
			$('#company_password_chk').keyup(function () {
              if ($('#company_pw').val() != $('#company_password_chk').val()) {
                  $('#company_pw').css('border', '2px solid red');
                  $('#company_password_chk').css('border', '2px solid red');
                  $('.compwchk').html('비밀번호 일치하지 않음');
                  $('.compwchk').css('color', 'red');
              } else {
              	$('#company_pw').css('border', '1px solid lightgray');
                  $('#company_password_chk').css('border', '1px solid lightgray');
                  $('.compwchk').html('');
                }
           });
			
			
			$('#member_email').focusout(function(){
				var member_email = $('#member_email').val();
				var data = {'member_email' : member_email}
					
				$.ajax({
					async : true,
					type : 'POST',
					url : '/UserEmailSearch',
					dataType: "json",
					//data : JSON.stringify(data),
					data : member_email,
					contentType: "application/json; charset=UTF-8"
					})
					.done(function(data){
					//	var str = data.member_email;
					//	if(str == "1"){ //아이디 있음
					//		$('.idchk').html('아이디 중복');
		            //      $('.idchk').css('color', 'red');
					//	}else{
					//		$('.idchk').html('');
					//	}
						if(data == 1){
							//alert("ajax 성공");
							$('.idchk').html('아이디 중복');
				            $('.idchk').css('color', 'red');
		                    $('#member_email').css('border', '2px solid red');
						}else{
						$('.idchk').html('');
						$('#member_email').css('border', '1px solid lightgray');
						}
						
					})
					.fail(function(error){
					})
				
			});
			
			$('#company_email').focusout(function(){
				var company_email = $('#company_email').val();
				var data = {'company_email' : company_email}
					
				$.ajax({
					async : true,
					type : 'POST',
					url : '/CompanyEmailSearch',
					dataType: "json",
					data : company_email,
					contentType: "application/json; charset=UTF-8"
					})
					.done(function(data){
						if(data == 1){
							//alert("ajax 성공");
							$('.comidchk').html('아이디 중복');
				            $('.comidchk').css('color', 'red');
		                    $('#company_email').css('border', '2px solid red');
						}else{
						$('.comidchk').html('');
						$('#company_email').css('border', '1px solid lightgray');
						}
					})
					.fail(function(error){
					})
				
			});
			
        });

        //카카오 로그인2
        function getProfile(){
            Kakao.API.request({
                url: '/v2/user/me',
                success: function(res) {
                    console.log(res); 
                  //$('#').value(res.kakao_account.profile.nickname);
                      $('#member_email').val(res.kakao_account.email);
                  	  var member_email = res.kakao_account.email;
					  var data = {'member_email' : member_email}
	                  $.ajax({
						type : 'POST',
						url : '/UserEmailSearch',
						dataType: "json",
						data : member_email,
						contentType: "application/json; charset=UTF-8"
						})
						.done(function(data){
							if(data == 1){//이미 아이디 있다는 소리니까 바로 로그인 진행
								var email = $('#member_email').val();
								var mem_email = {'mem_email':email};
							 	//alert("여기까지오나?");
								 $.ajax({
										type : 'POST',
										url : '/SignLogin',
										dataType: "json",
										data : mem_email,
										contentType: "application/json; charset=UTF-8"
										})
										.done(function(data){
											location.href = "/main";
											//window.location.replace("/Main");
										})
										.fail(function(error){})
								//window.location.assign('/LoginOK');
								//alert("ajax 성공");
							}else{
				                $(".signUpStep1Con").attr("style", "display:none");
				                $(".signUpStep2Con").attr("style", "display:show");
							}
						})
						.fail(function(error){
						})
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
        
        function unlinkApp() {
            Kakao.API.request({
              url: '/v1/user/unlink',
              success: function(res) {
                alert('success: ' + JSON.stringify(res))
              },
              fail: function(err) {
                alert('fail: ' + JSON.stringify(err))
              },
            })
          }                 
          function kakaoLogout() {
            if (!Kakao.Auth.getAccessToken()) {
              alert('Not logged in.')
              return
            }
            Kakao.Auth.logout(function() {
              alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken())
            })
          }
    </script>
    <script>
		//opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
		//document.domain = "abc.go.kr";
		
		function goPopup(){
			// 주소검색을 수행할 팝업 페이지를 호출합니다.
			// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
			var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 	
			// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
		}
		function jusoCallBack(roadAddrPart1,addrDetail,roadAddrPart2){
				// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
				document.getElementById('member_roadAddr').value = roadAddrPart1 + roadAddrPart2;
				document.getElementById('member_addrDetail').value = addrDetail;
				document.getElementById('company_roadAddr').value = roadAddrPart1 + roadAddrPart2;
				document.getElementById('company_addrDetail').value = addrDetail;	
		}
</script>
</head>
<body>
   <jsp:include page="include/header.jsp"/>
    <section>
        <div class="container">
            <div class="sign_wrap">
                <h2>회원가입</h2>

                <form class="new_member" id="new_member" name="new_member" method="post" action="/MemSign_up"><!-- action="#" -->
                    <div class="signUpStep1Con">
                        <div class="signup_box">
                            <ul>
                                <li id="member" class="tab_item on"><a>개인회원</a></li>
                                <li id="company" class="tab_item"><a>기업회원</a></li>
                            </ul>
                        </div>
                        <div class="member">
                            <div class="kakao_sign_up">
                                <a class="btnKakao" href="javascript:loginWithKakao()">카카오 1초 회원가입</a>
                            </div>
                            <div>또는</div>
                            <div class="member_sign_up">
                                <input type="text" id="member_email" name="mem_useremail" class="input" placeholder="이메일">
                                <div class="idchk"></div>
                                <input type="password" id="member_pw" name="mem_password" class="input" placeholder="비밀번호(10자리 이상)">
                                <input type="password" id="member_password_chk" class="input" placeholder="비밀번호 확인">
                                <div class="pwchk"></div>
                                <button type="button" class="sing_up" onclick="MemSign_up_step1();" >이메일로 가입</button> <!--onclick="signUpStep2ConGo()"-->
                            </div>
                        </div>
                    </div>
                    <div class="signUpStep2Con" style="display: none;">
                        <p style="text-align: left;">개인회원</p>
                        <div class="member_Detail">
                            <h3>성별을 입력하세요</h3>
                            <div class="sex">
                                <input type="radio" name="mem_sex" value="남" checked />&nbsp;남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="mem_sex" value="여" />&nbsp;여
                            </div>
                            <h3>생일을 입력하세요</h3>
                            <div class="birth">
                                <select name="mem_birth_year" class="select">
                                    <option value="1988">1988</option>
                                    <option value="1989">1989</option>
                                    <option value="1990">1990</option>
                                    <option value="1991">1991</option>
                                    <option value="1992">1992</option>
                                    <option value="1993">1993</option>
                                    <option value="1994">1994</option>
                                    <option value="1995">1995</option>
                                    <option value="1996">1996</option>
                                    <option value="1997">1997</option>
                                    <option value="1998">1998</option>
                                    <option value="1999">1999</option>
                                    <option value="2000">2000</option>
                                    <option value="2001">2001</option>
                                    <option value="2002">2002</option>
                                    <option value="2003">2003</option>
                                    <option value="2004">2004</option>
                                    <option value="2005">2005</option>
                                    <option value="2006">2006</option>
                                    <option value="2007">2007</option>
                                    <option value="2008">2008</option>
                                    <option value="2009">2009</option>
                                    <option value="2010">2010</option>
                                    <option value="2011">2011</option>
                                    <option value="2012">2012</option>
                                    <option value="2013">2013</option>
                                    <option value="2014">2014</option>
                                    <option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021" selected>2021</option>
                                </select> 년 &nbsp;
                                <select name="mem_birth_month" class="select">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                    <option value="04">04</option>
                                    <option value="05">05</option>
                                    <option value="06">06</option>
                                    <option value="07">07</option>
                                    <option value="08">08</option>
                                    <option value="09">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select> 월 &nbsp;
                                <select name="mem_birth_day" class="select">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                    <option value="04">04</option>
                                    <option value="05">05</option>
                                    <option value="06">06</option>
                                    <option value="07">07</option>
                                    <option value="08">08</option>
                                    <option value="09">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select> 일 &nbsp;
                            </div>
                            <h3>이름을 입력하세요</h3>
                            <input type="text" id="member_name" name="mem_name" class="input">
                          
                            <h3>핸드폰 번호를 입력하세요</h3>
                            <input type="text" id="member_phone" name="mem_phone" class="input" placeholder="숫자만 입력하세요 ex) 01012341234"> <!--유효성 검사로 10,11자리만 허용하게 하면 되겠네-->
                            <h3>주소를 입력하세요</h3>
                            <!--주소 입력 추가-->
                            <input type="text" id="member_roadAddr" name="mem_roadAddr" class="input roadadd" placeholder="도로명주소" style="width: 265px;"> <button type="button" class="btn member_Addr" onclick="goPopup();" > <img src="${contextPath}/resources/images/magnifying-glass-1976105_1280.png" style="width: 14px; height: 14px;"></button>
                            <input type="text" id="member_addrDetail" name="mem_addrDetail" class="input" placeholder="상세주소">
                            <button type="button" class="member_sign_up" onclick="MemSign_up_step2()">회원가입</button>
                        </div>
                    </div>
                </form>
                <form id="new_company" name="new_company" method="POST" action="/ComSign_up" enctype="multipart/form-data"><!--enctype="multipart/form-data"는 모든 문자를 인코딩하지 않음을 명시함. 이 방식은 <form> 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용함.-->
                    <div class="company" style="display: none;">
                        <p style="text-align: left;  font-size: 12px; padding-bottom: 10px; color: red;">명함에 기재된 이메일로 가입해주세요</p>
                        <div class="company_sign_up">
                            <input type="text" id="company_email" name="com_useremail" class="input"
                                placeholder="이메일">
                            <div class="comidchk"></div>
                            <input type="password" id="company_pw" name="com_password" class="input"
                                placeholder="비밀번호(10자리 이상)">
                            <input type="password" id="company_password_chk" class="input" placeholder="비밀번호 확인">
                            <div class="compwchk"></div>
                            <h3>기업명</h3>
                            <input type="text" id="company_name" name="com_name" class="input" placeholder="(주)코잇잡">
                            <h3>회사주소</h3>
                            <input type="text" id="company_roadAddr" name="com_roadAddr" class="input roadadd" placeholder="도로명주소" style="width: 265px;"> <button type="button" class="btn member_Addr" onclick="goPopup();" > <img src="${contextPath}/resources/images/magnifying-glass-1976105_1280.png" style="width: 14px; height: 14px;"></button>
                            <input type="text" id="company_addrDetail" name="com_addrDetail" class="input" placeholder="상세주소">
                            <h3>회사 연락처</h3>
                            <input type="text" id="company_tel" name="com_tel" class="input" placeholder="숫자만 입력하세요 ex) 01012341234"> <!--유효성 검사로 10,11자리만 허용하게 하면 되겠네-->
                            <h3>기업 이미지</h3>
                            <input type="file" class="file company_img" id="company_img" name="company_img" accept="image/*">
                            <button type="button" class="company_sing_up" onclick="ComSign_up();">기업회원가입</button>
                        </div>
                    </div>
                </form>
            </div>
         </div>
    </section>
 <jsp:include page="include/footer.jsp"/>
</body>
</html>