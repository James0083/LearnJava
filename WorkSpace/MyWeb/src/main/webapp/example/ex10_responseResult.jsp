<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<%
	request.setCharacterEncoding("UTF-8");
	//아이디, 비번 받기
	String uid=request.getParameter("userid");
	String upw=request.getParameter("pwd");
	System.out.println(uid+"/"+upw);
	//유효성 체크
	//[1] null값이면 => 제대로된 경로로 페이지 이동
	if(uid==null||upw==null){
		response.sendRedirect("ex10_response.jsp");
		return;
	}
	System.out.println("여기가 수행 될까요?");
	//[2] 빈문자열이면 => 400에러 (잘못된 요청 에러)
	if("".equals(uid.trim())||"".equals(upw.trim())){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	//[3] killer면 => 403에러 (접근금지 -forbidden)
	if(uid.equalsIgnoreCase("killer")){
		response.sendError(response.SC_FORBIDDEN);
		return;
	}
	
%>
<div class="container">
<h1 style='color:blue'><%=uid %> 님 환영합니다</h1>
<br><br>
[<a href="ex10_response.jsp">로그인 페이지로</a>]
</div>

<jsp:include page="/foot.jsp"/>