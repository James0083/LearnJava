<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!-- page지시어에 isErrorPage="true"를 주어야 한다. exception내장객체를 사용할 수 있다. -->
<jsp:include page="/top.jsp"/>

    <div class="container">
    	<div class="error">
    		<h1>Server Error</h1>
    		<h2><%=exception.getMessage() %></h2>
    		[<a style="color:navy" href="javascript:history.back()">이전 페이지로 돌아가기</a>]
    		<button onclick="history.back()">이전 페이지로 돌아가기</button>
    		<%
    			exception.printStackTrace();//디버그용 => 톰캣 콘솔에 출력한다
    		%>
    	</div>
    </div>
<jsp:include page="/foot.jsp"/>