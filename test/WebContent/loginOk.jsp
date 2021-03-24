<%@page import="t1.MemberDao"%>
<%@page import="t1.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	MemberDao dao = MemberDao.getInstance();
	int checkNum = dao.userCheck(id,pw);
	
	// 로그인정보 체크
	if(checkNum == -1){
%>
		<script language="javascript">
			alert("아이디가 존재 하지않습니다.");
			history.go(-1);
		</script>
<%
	}else if(checkNum == 0){
		
%>
		<script language="javascript">
			alert("비밀번호가 틀립니다.");
			history.go(-1);
		</script>
<%
	}else if(checkNum == 1){
		MemberDto dto = dao.getMember(id);
		
		if(dto == null){
			
%>
		<script language="javascript">
			alert("존재하지 않는 회원 입니다.");
			history.go(-1);
		</script>
<%
		}else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "ValidMem");
			response.sendRedirect("main.jsp");
		}
	}
%>