<%@page import="t1.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dto" class="t1.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDao dao = MemberDao.getInstance();
	int ri = dao.updateMember(dto);
	
	if(ri == 1){
%>
		<script language="javascript">
			alert("정보가 수정되었습니다.");
			document.location.href="main.jsp";
		</script>		
<%
	}else{
		
%>	
		<script language="javascript">
			alert("정보수정을 실패하셨습니다.");
			history.go(-1);
		</script>		
<%
	}
%>
	