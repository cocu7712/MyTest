<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="../../resources/jquery/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../resources/css/Bomi/findIdStyle.css" />
<title>findId</title>
<script type="text/javascript">
	window.onload = function(){
		function onClick(){
			document.querySelector('.background_modal').style.display='block';
			document.querySelector('.modal_contesnts').style.display='block';
		}
		function offClick(){
			document.querySelector('.background_modal').style.display='none';
			document.querySelector('.modal_contesnts').style.display='none';	
		}
		
		document.getElementById('searchBtn').addEventListener('click', onClick);
		document.querySelector('.close').addEventListener('click',offClick);
	};
</script>
<script>
//함수 정의
	function idSerch_Click(){
		var mem_username= $("#mem_username").val();
		var mem_phone = $("#member_phone").val();
		var param = {'mem_username': mem_username,
					'mem_phone' : mem_phone};
		console.log(mem_phone);
		$.ajax({
			type : 'POST', //전송 방식
			url : '/userEmailSearch',
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			data : JSON.stringify(param)
			})
			.done(function(data){
				console.log(data);
				//alert('성공');
				var str = data.mem_userEmail;
				$('#id_value').text(str);
				//if(str == "회원 정보를 확인해주세요!"){
				//	System.out.print(str);
				//	$('#id_value').text("회원 정보를 확인해주세요!");
				//}else{
				//	console.log(data);
				//	System.out.print(str);
				//	$('#id_value').text(str);
					//아이디값 별도로 저장
				//	var idV = str;
				//}
			})
			.fail(function(errorThrown){
				alert("error");
				console.log(errorThrown);
			})
		};
</script>
</head>
<body>
	<%@ include file="findIdModal.jsp" %>
    <div class="container">
        <div class="header"></div>
        <div class="left"></div>
        <div class="right"></div>
        <div class="section">
            <div class="FindContainer">
                <h2>Find ID</h2>
                <p>이름과 휴대폰번호로 아이디 찾기가 가능합니다.</p>
                <hr>
                <div class="content">
                    <div class="center">
                        <form id="idFindForm">
                        <div class="find">
                            <div class="find_id">
                                <table>
                                    <colgroup>
                                        <col style="width:120px;">
                                        <col style="width:220px;">
                                    </colgroup>
                                    <tr>
                                        <td>
                                            <p class="txt">이름</p>
                                        </td>
                                        <td><input type="text" class="member member_name" name="mem_username" id="mem_username" placeholder="예)홍길동"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p class="txt">핸드폰번호</p>
                                        </td>
                                        <td>
                                            <input type="text" style="width: 200px;" maxlength="11" class="mobile num1" id="member_phone" name="phone" placeholder="예)01012341234" /> 
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="btn ok">
                            <input type="button" id="searchBtn" value="ID찾기" onclick="idSerch_Click()"/>
                            <input type="button" id="Main" value="메인으로" onclick="location.href='/Main'"/>
                        </div>
                        </form>
                    </div>
                </div>
                <hr>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</body>

</html>