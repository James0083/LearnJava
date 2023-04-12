<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
ex02.jsp<br>
<%-- [1] for루프 이용해서 Hello JSP를 5번 출력하세요 --%>
<% 
	for(int i=0;i<5;i++){ 
%>
<h2>Hi JSP <%=i %></h2>
<% 
	}
%>
<hr color='red'>
<% 
for(int i=0;i<5;i++){ 
	out.println("<h2>Hello JSP "+i+"</h2>");
} 
%>
<hr color='blue'>

<%--
[2] while루프 이용해서 구구단 8단을 출력하세
--%>
<table border="1">
<% 
	int i=1;
	int dan=8;
	while(i<10){
		%>
		<tr><td><%=dan %>*<%=i %>=<%=dan*i %></td></tr>
		<%
		i++;
	}
%>
</table>