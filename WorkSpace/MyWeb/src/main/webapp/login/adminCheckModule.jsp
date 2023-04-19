<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- adminCheckModule.jsp -->
<%--
관리자 여부를 체크하는 모듈 (관리자는 mstate값이 9)
	1. 로그인이 되어있어야 하고	==> loginCheckModule.jsp
	2. 정지회원은 아니어야 함		==> loginCheckModule.jsp
	3. mstate값은 9여야
--%>
<%@ include file="/login/loginCheckModule.jsp"%>
<%
	if(member.getMstate()!=9){
		%>
		<script>
			alert('관리자만 이용할 수 있아요');
			history.back();
		</script>
		<%
		return;
	}
%>