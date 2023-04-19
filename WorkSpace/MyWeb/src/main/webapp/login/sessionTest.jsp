<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!-- sessionTest.jsp -->
<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>session에 저장된 모든 정보를 꺼내보자</h1>
    	<h2 style='color:tomato'>
    	JSESSIONID: <%=session.getId() %>
    	</h2>
    	<%
    		Enumeration<String> en = session.getAttributeNames();
    		while(en.hasMoreElements()){
    			String key=en.nextElement(); //key값
    			Object value=session.getAttribute(key);
    			%>
    			<h2><%=key %> : <%=value %></h2>
    			<%
    		}//while---------------
    	%>
    </div>
<jsp:include page="/foot.jsp"/>