<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 처리 방법
	//[1] 세션에 저장된 특정 변수를 삭제
	//session.removeAttribute("loginUser");
	
	//[2] 세션에 저장된 모든 변수를 삭제 ==> 권장
	session.invalidate();
	response.sendRedirect("../main.jsp");
%>