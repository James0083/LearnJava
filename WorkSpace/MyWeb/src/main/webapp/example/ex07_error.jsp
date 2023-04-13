<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" info="에러 처리 방법을 알아보는 페이지" buffer="4kb" %>
<%@ page errorPage="error.jsp" %>
<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>JSP에서 에러처리</h1>
    	
    	<h2><%=this.getServletInfo() %></h2>
    	<%
    		Random ran=new Random();
    		int num = ran.nextInt(100)+10;
    		//10<= num <110
    		int res=num/0; //ArithmeticException
    		out.println("res: "+res);
    	%>
    	<h2 style='color:purple'>랜덤한 정수: <%=num %></h2>
    </div>
<jsp:include page="/foot.jsp"/>