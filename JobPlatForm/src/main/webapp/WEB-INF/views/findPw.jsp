<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../resources/css/Bomi/findPwStyle.css" />
<title>findPw</title>
</head>

<body>
    <div class="container">
        <div class="header"></div>
        <div class="left"></div>
        <div class="right"></div>
        <div class="section">
            <div class="FindContainer">
                <h2>Find PW</h2>
                <p>아이디와 이메일로 임시 비밀번호를 발급받을 수 있습니다.</p>
                <hr>
                <div class="content">
                    <div class="center">
                      <form id="pwFindForm" action="/userPwSearch" method="post">
                        <div class="find">
                            <div class="find_pw">
                                <table>
                                    <colgroup>
                                        <col style="width:120px;">
                                        <col style="width:220px;">
                                    <tr>
                                        <td>
                                            <p class="txt">이름</p>
                                        </td>
                                        <td><input type="text" class="member member_name" name="mem_username" placeholder="회원가입한 이름" /></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p class="txt">이메일</p>
                                        </td>
                                        <td>
                                            <input type="text" id="mem_email" name="mem_email" placeholder="회원가입한 이메일주소(아이디)" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="btn ok">
                            <input type="submit" value="PW찾기" id="searchBtn"/>
                            <input type="button" id="Main" value="메인으로" onclick="location.href='/Maintest'"/>
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